package ds.tree;

public interface Tree<T> {
    boolean add(T value);

    T remove(T value);

    boolean contains(T value);

    int size();
}
