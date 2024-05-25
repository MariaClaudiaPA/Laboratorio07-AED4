package ejercicios;

import exceptions.*;

public class Test {

    public static void main(String[] args) {
        //Ejercicio 01
        System.out.println("Caso de prueba:");
        BSTree<Integer> tree = new BSTree<>();
        try {
            tree.insert(10);
            tree.insert(5);
            tree.insert(15);
            tree.insert(3);
            tree.insert(7);
            tree.insert(12);
            tree.insert(17);

            int heightOf10 = tree.height(10);
            System.out.println("Altura del nodo 10: " + heightOf10);

            int countNodes = tree.count_Nodes();
            System.out.println("Número de nodos no-hoja: " + countNodes);

        } catch (ItemDuplicated | ItemNoFound | ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        //Ejercicio 02
        BSTree<Integer> tree1 = new BSTree<>();
        try {
            tree1.insert(10);
            tree1.insert(5);
            tree1.insert(15);
            tree1.insert(3);
            tree1.insert(7);
            tree1.insert(12);
            tree1.insert(17);
            System.out.println("Área del primer árbol: " + tree1.areaBST());
            //Ejercicio 03
            System.out.println("Recorrido en preorden del árbol:");
            tree1.iterativePreOrden();
        } catch (ItemDuplicated | ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        BSTree<Integer> tree2 = new BSTree<>();
        try {
            tree2.insert(50);
            tree2.insert(30);
            tree2.insert(70);
            tree2.insert(20);
            tree2.insert(40);
            tree2.insert(60);
            tree2.insert(80);
            System.out.println("Área del segundo árbol: " + tree2.areaBST());
            //Ejercicio 03
            System.out.println("Recorrido en preorden del árbol:");
            tree2.iterativePreOrden();
        } catch (ItemDuplicated | ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        boolean sameArea = sameArea(tree1, tree2);
        System.out.println("¿Los dos árboles tienen la misma área? " + sameArea);
        //Ejercicio 04
        BSTree<Integer> tree4 = new BSTree<>();
        try {
            tree4.insert(10);
            tree4.insert(5);
            tree4.insert(15);
            tree4.insert(3);
            tree4.insert(7);
            tree4.insert(12);
            tree4.insert(17);
            int totalNodes = tree4.countNodes();
            System.out.println("Número total de nodos en el árbol: " + totalNodes);
        } catch (ItemDuplicated e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
    //Ejercicio 02
    public static <E extends Comparable<E>> boolean sameArea(BSTree<E> tree1, BSTree<E> tree2) {
        try {
            int areaTree1 = tree1.areaBST();
            int areaTree2 = tree2.areaBST();

            return areaTree1 == areaTree2;

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción al calcular el área de un árbol: " + e.getMessage());
            return false;
        }

    }
}
