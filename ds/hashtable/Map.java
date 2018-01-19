package ds.hashtable;

public class Map<T1, T2> {
    private T1 key;
    private T2 value;
    private boolean isDeleted;

    public Map (T1 key, T2 value) {
        this.key = key;
        this.value = value;
        this.isDeleted = false;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }

    public boolean getIsDelete() {
        return isDeleted;
    }

    public void setIsDeleted (boolean bool) {
        isDeleted = bool;
    }
}
