package ds.hashtable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class HashTableChainingTest {
    private HashTable<Object, Object> chainedHashTable;
    private HashMap<Integer, Integer> inputHashMap;
    private HashMap<Object, Object> objectInputHashMap;

    @Before
    public void setUp() {
        chainedHashTable = new HashTableChaining(10);

        inputHashMap = new HashMap<>();
        inputHashMap.put(17, 170);
        inputHashMap.put(27, 270);

        objectInputHashMap = new HashMap<>();
        objectInputHashMap.put("id", 201323160);
        objectInputHashMap.put(941230, "minji's birthday date");
        objectInputHashMap.put("job", "backssu");
    }

    // 확인 어떻게 해야할지 모르겠음...
    // test를 위해 insert 함수 return 변경?
    // hasedkey가 7인 위치에 저장되었는지 확인
    @Test
    public void testInsert() {
        chainedHashTable.insert(17, inputHashMap.get(17));

        // 같은 hasedKey일 경우 list에 추가되는지 확인
        chainedHashTable.insert(27, inputHashMap.get(27));

        // key 중복확인
        chainedHashTable.insert(27, inputHashMap.get(27));
    }

    @Test
    public void testObjectInsert() {
        for (Map.Entry<Object, Object> entry : objectInputHashMap.entrySet()) {
            boolean result = chainedHashTable.insert(entry.getKey(), entry.getValue());
            assertEquals(true, result);
        }
    }

    @Test
    public void testGet() {
        testObjectInsert();
        for (Map.Entry<Object, Object> entry: objectInputHashMap.entrySet()) {
            assertEquals(entry.getValue(), chainedHashTable.get(entry.getKey()));
        }
        assertEquals(-1, chainedHashTable.get(9));
    }

    @Test
    public void testRemove() {
        testObjectInsert();
        for (Map.Entry<Object, Object> entry : objectInputHashMap.entrySet()) {
            assertEquals(entry.getValue(), chainedHashTable.remove(entry.getKey()));
            assertEquals(-1, chainedHashTable.get(entry.getKey()));
        }
    }
}