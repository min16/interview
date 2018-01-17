package ds.hashtable;

public class HashTable {
    private HashNode[] table;
    private int tableSize;

    public class HashNode {
        int key;
        int value;
        boolean isDeleted;

        public HashNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        table = new HashNode[tableSize];
    }

    public void insertLinearProbe(int key, int value) {
        int hashedKey = hash(key);
        while (table[hashedKey] != null) {
            if (hasKey(hashedKey, key)) return;
            hashedKey = linearProbe(hashedKey);
        }
        table[hashedKey] = new HashNode(key, value);
    }

    // hashedKey 인덱스 값에 null이 있으면 존재하지 않는 key
    public int getLinearProbe(int key) {
        int hashedKey = hash(key);
        while (table[hashedKey] != null) {
            if (hasKey(hashedKey, key)) {
                return table[hashedKey].value;
            }
            hashedKey = linearProbe(hashedKey);
        }
        return -1;
    }

    public HashNode deleteLinearProbe(int key) {
        int hashedKey = hash(key);
        while (table[hashedKey] != null) {
            if (hasKey(hashedKey, key)) {
                table[hashedKey].isDeleted = true;
                return table[hashedKey];
            }
            hashedKey = linearProbe(hashedKey);
        }
        return null;
    }

    private boolean hasKey(int hashedKey, int key) {
        return table[hashedKey].key == key && !table[hashedKey].isDeleted;
    }

    private int linearProbe(int hashedKey) {
        return  (hashedKey + 1) % tableSize;
    }
    private int hash(int key) {
        return key % tableSize;
    }
}
