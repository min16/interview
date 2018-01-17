package ds.hashtable;

import java.util.ArrayList;

public class HashTableChaining {

    public class HashNode {
        int key;
        int value;

        public HashNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public ArrayList<HashNode>[] table;
    private int tableSize;

    public HashTableChaining(int tableSize) {
        this.tableSize = tableSize;
        table = new ArrayList[tableSize];
    }

    public int simpleHash(int key) {
        return key % tableSize;
    }

    public void insert(int key, int value) {
        int hashedKey = simpleHash(key);
        if (table[hashedKey] == null) {
            table[hashedKey] = new ArrayList<>();
        } else {
            for (HashNode hashNode : table[hashedKey]) {
                if (hashNode.key == key) return;
            }
        }
        table[hashedKey].add(new HashNode(key, value));
    }

    public int get(int key) {
        int hashedKey = simpleHash(key);
        if (table[hashedKey] == null) return -1;
        for (HashNode hashNode : table[hashedKey]) {
            if (hashNode.key == key) return hashNode.value;
        }
        return -1;
    }

}
