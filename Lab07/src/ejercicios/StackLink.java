package ejercicios;

public class StackLink<E> implements Stack<E> {

    private Node<E> tope;

    public StackLink() {
        this.tope = null;
    }

    @Override
    public void push(E x) {
        Node<E> nuevoNodo = new Node<>(x);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        E data = tope.getData();
        tope = tope.getSiguiente();
        return data;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return tope.getData();
    }

    @Override
    public boolean isEmpty() {
        return tope == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> actual = tope;
        while (actual != null) {
            sb.append(actual.getData());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }
}
