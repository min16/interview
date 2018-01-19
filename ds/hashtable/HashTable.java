package ds.hashtable;

// <K, V>로 나타내는 게 맞나?
// table도 선언해야하나? (하지만 OA에는 isDeleted가 없음)

public interface HashTable<T1, T2> {
    boolean insert(T1 t1, T2 t2);

    T1 get(T1 t);

    T1 remove(T1 t);

    Integer hash(T1 t);
}
