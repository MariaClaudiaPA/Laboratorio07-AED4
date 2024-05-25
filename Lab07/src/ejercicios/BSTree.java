package ejercicios;

import treelink.*;
import exceptions.*;

public class BSTree<E extends Comparable<E>> implements LinkBST<E> {

    class Node {

        protected E data;
        protected Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public E getData() {
            return data;
        }
    }

    private Node root;

    public BSTree() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void insert(E x) throws ItemDuplicated {

        if (root == null) {
            root = new Node(x);
            return;
        }
        Node padre = null;
        Node actual = root;

        while (actual != null) {
            padre = actual;
            if (x.compareTo(actual.data) < 0) {
                actual = actual.left;
            } else if (x.compareTo(actual.data) > 0) {
                actual = actual.right;
            } else {
                throw new ItemDuplicated("Item ya existe en el BST");
            }
        }
        if (x.compareTo(padre.data) < 0) {
            padre.left = new Node(x);
        } else {
            padre.right = new Node(x);
        }
    }

    @Override
    public E search(E x) throws ItemNoFound {
        Node actual = root;
        while (actual != null) {
            if (x.compareTo(actual.data) < 0) {
                actual = actual.left;
            } else if (x.compareTo(actual.data) > 0) {
                actual = actual.right;
            } else {
                return actual.data;
            }
        }
        throw new ItemNoFound("Item no encontrado en el BST");
    }

    @Override
    public void remove(E x) throws ItemNoFound {
        root = remove(root, x);
    }

    private Node remove(Node root, E x) throws ItemNoFound {

        if (root == null) {
            throw new ItemNoFound("Item no encontrado en el BST");
        }

        Node padre = null;
        Node actual = root;
        boolean isLeftChild = false;

        while (actual != null && !actual.data.equals(x)) {
            padre = actual;
            if (x.compareTo(actual.data) < 0) {
                isLeftChild = true;
                actual = actual.left;
            } else {
                isLeftChild = false;
                actual = actual.right;
            }
        }

        if (actual == null) {
            throw new ItemNoFound("Item no encontrado en el BST");
        }

        // caso 1: nodo con cero hijos (hoja)
        if (actual.left == null && actual.right == null) {
            if (actual == root) {
                return null;
            } else if (isLeftChild) {
                padre.left = null;
            } else {
                padre.right = null;
            }
        } // caso 2: nodo con un solo hijo
        else if (actual.right == null) {
            if (actual == root) {
                return actual.left;
            } else if (isLeftChild) {
                padre.left = actual.left;
            } else {
                padre.right = actual.left;
            }
        } else if (actual.left == null) {
            if (actual == root) {
                return actual.right;
            } else if (isLeftChild) {
                padre.left = actual.right;
            } else {
                padre.right = actual.right;
            }
        } // caso 3: nodo con dos hijos
        else {
            Node sucesor = minRemove(actual.right);

            sucesor.left = actual.left;
            if (actual.right != sucesor) {
                sucesor.right = actual.right;
            }

            if (actual == root) {
                root = sucesor;
            } else if (isLeftChild) {
                padre.left = sucesor;
            } else {
                padre.right = sucesor;
            }

            return root;
        }

        return root;
    }

    private Node minRemove(Node root) throws ItemNoFound {
        if (root == null) {
            throw new ItemNoFound("No hay elementos");
        }
        Node actual = root;
        while (actual.left != null) {
            actual = actual.left;
        }
        return actual;
    }

    public E obtMinRemove() throws ItemNoFound {
        Node minNode = minRemove(root);
        if (minNode == null) {
            throw new ItemNoFound("No se encontró el valor mínimo en el árbol");
        }
        return minNode.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node root, StringBuilder sb) {
        if (root != null) {
            inOrder(root.left, sb);
            sb.append(root.data).append(" ");
            inOrder(root.right, sb);
        }
    }

    //Ejercicio 01.a
    public int count_Nodes() throws ExceptionIsEmpty {
        if (root == null) {
            return 0;
        }
        StackLink<Node> stack = new StackLink<>();
        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.left != null || node.right != null) {
                count++;
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return count;
    }

    //Ejercicio 01.b
    public int height(E x) throws ItemNoFound {
        Node node = encontrarNodo(root, x);
        if (node == null) {
            throw new ItemNoFound("Item no encontrado en el BST");
        }
        return calcularHeight(node);
    }

    private Node encontrarNodo(Node root, E x) {
        while (root != null) {
            if (x.compareTo(root.data) < 0) {
                root = root.left;
            } else if (x.compareTo(root.data) > 0) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    private int calcularHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = calcularHeight(node.left);
        int rightHeight = calcularHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Ejercicio 02.a
    public int heightTotal() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    private int contarHojas(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return contarHojas(node.left) + contarHojas(node.right);
    }

    public int areaBST() throws ExceptionIsEmpty {
        if (root == null) {
            return 0;
        }
        int height = heightTotal();
        int hojasC = contarHojas(root);
        return height * hojasC;
    }

    //Ejercicio 03
    public void iterativePreOrden() throws ExceptionIsEmpty {
        if (root == null) {
            return;
        }

        StackLink<Node> stack = new StackLink<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node actual = stack.pop();
            System.out.print(actual.data + " ");

            if (actual.right != null) {
                stack.push(actual.right);
            }
            if (actual.left != null) {
                stack.push(actual.left);
            }
        }
    }

    //Ejercicio 04
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

}
