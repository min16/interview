package ds.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTableChaining implements HashTable<Object, Object>{

    public List<Map<Object, Object>>[] table;
    private int tableSize;

    public HashTableChaining(int tableSize) {
        this.tableSize = tableSize;
        table = new ArrayList[tableSize];
    }

    public Integer hash(Object key) {
        return key.hashCode() & 0xfffffff % tableSize;
    }

    public boolean insert(Object key, Object value) {
        int hashedKey = hash(key);
        if (table[hashedKey] == null) {
            table[hashedKey] = new ArrayList<>();
        } else {
            for (Map map : table[hashedKey]) {
                if (map.getKey() == key) return false;
            }
        }
        return table[hashedKey].add(new Map(key, value));
    }

    public Object get(Object key) {
        int hashedKey = hash(key);
        if (table[hashedKey] == null) return -1;
        for (Map map : table[hashedKey]) {
            if (map.getKey() == key) return map.getValue();
        }
        return -1;
    }

    public Object remove(Object key) {
        int hashedKey = hash(key);
        if (table[hashedKey] == null) return -1;
        for (Map map : table[hashedKey]) {
            if (map.getKey() == key) table[hashedKey].remove(map);
            return map.getValue();
        }
        return -1;
    }
}
