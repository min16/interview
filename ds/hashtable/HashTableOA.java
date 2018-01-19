package ds.hashtable;

public class HashTableOA implements HashTable<Object, Object>{
    private Map<Object, Object>[] table;
    private int tableSize;

    public HashTableOA(int tableSize) {
        this.tableSize = tableSize;
        table = new Map[tableSize];
    }

    public boolean insert(Object key, Object value) {
        int hashedKey = hash(key);
        while (table[hashedKey] != null) {
            if (hasKey(hashedKey, key)) return false;
            hashedKey = linearProbe(hashedKey);
        }
        table[hashedKey] = new Map<>(key, value);
        return true;
    }

    // hashedKey 인덱스 값에 null이 있으면 존재하지 않는 key
    public Object get(Object key) {
        int hashedKey = hash(key);
        while (table[hashedKey] != null) {
            if (hasKey(hashedKey, key)) {
                return table[hashedKey].getValue();
            }
            hashedKey = linearProbe(hashedKey);
        }
        return -1;
    }

    public Object remove(Object key) {
        int hashedKey = hash(key);
        while (table[hashedKey] != null) {
            if (hasKey(hashedKey, key)) {
                table[hashedKey].setIsDeleted(true);
                return table[hashedKey].getValue();
            }
            hashedKey = linearProbe(hashedKey);
        }
        return null;
    }

    private boolean hasKey(int hashedKey, Object key) {
        return table[hashedKey].getKey() == key && !table[hashedKey].getIsDelete();
    }

    public Integer hash(Object key) {
        return key.hashCode() & 0xfffffff % tableSize;
    }

    private int linearProbe(int hashedKey) {
        return  (hashedKey + 1) % tableSize;
    }
}
