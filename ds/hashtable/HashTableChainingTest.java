package ds.hashtable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

public class HashTableChainingTest {
    private HashTableChaining hashTable;
    private HashMap<Integer, Integer> inputHashMap;

    @Before
    public void setUp() {
        hashTable = new HashTableChaining(10);
        inputHashMap = new HashMap<>();
        inputHashMap.put(17, 170);
        inputHashMap.put(27, 270);
        testInsert();
    }

    // 확인 어떻게 해야할지 모르겠음...
    // test를 위해 insert 함수 return 변경?
    // hasedkey가 7인 위치에 저장되었는지 확인
    @Test
    public void testInsert() {
        hashTable.insert(17, inputHashMap.get(17));

        // 같은 hasedKey일 경우 list에 추가되는지 확인
        hashTable.insert(27, inputHashMap.get(27));

        // key 중복확인
        hashTable.insert(27, inputHashMap.get(27));
    }

    @Test
    public void testGet() {
        assertEquals((int) inputHashMap.get(17), hashTable.get(17));
        assertEquals(-1, hashTable.get(1));
        assertEquals(-1, hashTable.get(37));
        assertEquals((int) inputHashMap.get(27), hashTable.get(27));
    }
}