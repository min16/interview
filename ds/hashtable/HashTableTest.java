package ds.hashtable;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HashTableTest {
    private HashTable hashTable;
    private HashMap<Integer, Integer> inputHashMap;
    private int inputSize = 13;

    @Before
    public void setUp() {
        hashTable = new HashTable(inputSize * 2);
        inputHashMap = new HashMap<>();

        // create random input
        for (int i = 0; i < inputSize; i ++) {
            int key = (int) (Math.random() * Integer.MAX_VALUE) + 1;
            inputHashMap.put(key, key / 10);
        }
    }

    @Test
    public void testInsert() {
        putNewInput(17, 270);
        hashTable.insertLinearProbe(17, inputHashMap.get(17));
    }

    @Test
    public void testInsertAll() {
        for(Map.Entry<Integer, Integer> entry : inputHashMap.entrySet()) {
            hashTable.insertLinearProbe(entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void testGetAll() {
        testInsertAll();
        for(Map.Entry<Integer, Integer> entry : inputHashMap.entrySet()) {
            assertEquals((int) entry.getValue(), hashTable.getLinearProbe(entry.getKey()));
        }
    }

    @Test
    public void testDeleteAll() {
        testInsertAll();
        for(Map.Entry<Integer, Integer> entry : inputHashMap.entrySet()) {
            HashTable.HashNode hashNode = hashTable.deleteLinearProbe(entry.getKey());
            assertEquals((int) inputHashMap.get(hashNode.key), hashNode.value);
        }
    }

    @Test
    public void testDelete() {
        testInsert();
        HashTable.HashNode hashNode = hashTable.deleteLinearProbe(17);
        assertEquals((int) inputHashMap.get(hashNode.key), hashNode.value);
    }

    @Test
    public void testDeleteNotExist() {
        HashTable.HashNode hashNode = hashTable.deleteLinearProbe(1);
        assertEquals(null, hashNode);
    }

    private void putNewInput(int key, int value) {
        inputHashMap.put(key, value);
    }
}
