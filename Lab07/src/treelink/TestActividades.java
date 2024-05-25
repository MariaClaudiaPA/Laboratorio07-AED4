package treelink;

import ejercicios.BSTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class TestActividades {

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        try {
            // Caso 1: Árbol vacío
            System.out.println("Caso 1 - Árbol vacío: " + tree.isEmpty());

            // Caso 2: Insertar un solo elemento
            tree.insert(10);
            System.out.println("Caso 2 - Solo la raíz: " + tree.toString());
            // Caso 3: Insertar más elementos
            tree.insert(5);
            tree.insert(15);
            tree.insert(3);
            tree.insert(7);
            tree.insert(12);
            tree.insert(17);
            System.out.println("Caso 3 - Árbol con varios elementos: " + tree.toString());
            // Buscar un elemento existente
            try {
                System.out.println("Buscar 7: " + tree.search(7));
            } catch (ItemNoFound e) {
                System.out.println(e.getMessage());
            }
            // Buscar un elemento no existente
            try {
                System.out.println("Buscar 20: " + tree.search(20));
            } catch (ItemNoFound e) {
                System.out.println(e.getMessage());
            }
            // Eliminar un elemento sin hijos (hoja)
            tree.remove(3);
            System.out.println("Caso 4 - Después de eliminar 3 (hoja): " + tree.toString());

            // Eliminar un elemento con un hijo
            tree.remove(15);
            System.out.println("Caso 5 - Después de eliminar 15 (con un hijo): " + tree.toString());

            // Eliminar un elemento con dos hijos
            tree.remove(5);
            System.out.println("Caso 6 - Después de eliminar 5 (con dos hijos): " + tree.toString());
            // Imprimir el árbol en orden
            System.out.println("Árbol en orden: " + tree.toString());
            System.out.println("Valor más bajo: " + tree.obtMinRemove());
        } catch (ItemDuplicated | ItemNoFound e) {
            System.out.println(e.getMessage());
        }
    }
}
