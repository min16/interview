package ds.tree;

public interface Tree<T> {
    public boolean add(T value);

    public T remove(T value);

    public boolean contains(T value);

    public int size();

    public boolean validate();
}
