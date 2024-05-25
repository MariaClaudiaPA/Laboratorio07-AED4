package treelink;

import ejercicios.BSTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class TestActividades {

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        try {
            // Caso 1: �rbol vac�o
            System.out.println("Caso 1 - �rbol vac�o: " + tree.isEmpty());

            // Caso 2: Insertar un solo elemento
            tree.insert(10);
            System.out.println("Caso 2 - Solo la ra�z: " + tree.toString());
            // Caso 3: Insertar m�s elementos
            tree.insert(5);
            tree.insert(15);
            tree.insert(3);
            tree.insert(7);
            tree.insert(12);
            tree.insert(17);
            System.out.println("Caso 3 - �rbol con varios elementos: " + tree.toString());
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
            System.out.println("Caso 4 - Despu�s de eliminar 3 (hoja): " + tree.toString());

            // Eliminar un elemento con un hijo
            tree.remove(15);
            System.out.println("Caso 5 - Despu�s de eliminar 15 (con un hijo): " + tree.toString());

            // Eliminar un elemento con dos hijos
            tree.remove(5);
            System.out.println("Caso 6 - Despu�s de eliminar 5 (con dos hijos): " + tree.toString());
            // Imprimir el �rbol en orden
            System.out.println("�rbol en orden: " + tree.toString());
            System.out.println("Valor m�s bajo: " + tree.obtMinRemove());
        } catch (ItemDuplicated | ItemNoFound e) {
            System.out.println(e.getMessage());
        }
    }
}
