package ejercicios;

public class Node<E> {

    E data;
    Node<E> siguiente;

    public Node(E data) {
        this(data, null);
    }
    public Node(E data, Node<E> siguiente) {
        this.data = data;
        this.siguiente = siguiente;
    }

    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    public Node<E> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Node<E> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo[" + "data=" + data + ", siguiente=" + siguiente + ']';
    }
}
