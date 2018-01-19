package ds.hashtable;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HashTableOATest {
    private HashTable<Object, Object> hashTableOA;
    private HashMap<Integer, Integer> inputHashMap;
    private HashMap<Object, Object> objectInputHashMap;
    private int inputSize = 13;

    @Before
    public void setUp() {
        hashTableOA = new HashTableOA(inputSize * 2);
        inputHashMap = new HashMap<>();

        // create random input
        for (int i = 0; i < inputSize; i ++) {
            int key = (int) (Math.random() * Integer.MAX_VALUE) + 1;
            inputHashMap.put(key, key / 10);
        }

        objectInputHashMap = new HashMap<>();
        objectInputHashMap.put("id", 201323160);
        objectInputHashMap.put(941230, "minji's birthday date");
        objectInputHashMap.put("job", "backssu");
    }

    @Test
    public void testInsertAll() {
        for(Map.Entry<Object, Object> entry : objectInputHashMap.entrySet()) {
            boolean result = hashTableOA.insert(entry.getKey(), entry.getValue());
            assertEquals(true, result);
        }
    }

    @Test
    public void testGetAll() {
        testInsertAll();
        for(Map.Entry<Object, Object> entry : objectInputHashMap.entrySet()) {
            assertEquals(entry.getValue(), hashTableOA.get(entry.getKey()));
        }
    }

    @Test
    public void testDeleteAll() {
        testInsertAll();
        for(Map.Entry<Object, Object> entry : objectInputHashMap.entrySet()) {
            Object value = hashTableOA.remove(entry.getKey());
            assertEquals(objectInputHashMap.get(entry.getKey()),value);
        }
    }

    @Test
    public void testDeleteNotExist() {
        assertEquals(null, hashTableOA.remove("please remove this"));
    }
}
