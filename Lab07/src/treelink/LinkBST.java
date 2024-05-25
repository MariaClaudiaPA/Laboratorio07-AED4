package treelink;
import exceptions.*;

public interface LinkBST<E extends Comparable<E>> {

    void insert(E x) throws ItemDuplicated;
    void remove(E x) throws ItemNoFound;
    E search(E x) throws ItemNoFound;
    boolean isEmpty();
}


