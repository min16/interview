package ds.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {
    private PriorityQueue priorityQueue;
    private int priorityQueueSize = 10;
    private int[] input = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

    @Before
    public void setUp() {
        priorityQueue = new PriorityQueue(priorityQueueSize);
    }

    @Test
    public void testPeek() {
        int[] output = new int[]{16, 14, 10, 9, 8, 7, 4, 3, 2, 1};
        testInsertAll();
        for(int i : output) {
            int max = priorityQueue.peek();
            assertEquals(i, max);
            priorityQueue.pop();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekWhenEmpty() {
        assertEquals(true, priorityQueue.isEmpty());
        priorityQueue.peek();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopWhenEmpty() {
        assertEquals(true, priorityQueue.isEmpty());
        priorityQueue.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWhenFull() {
        testInsertAll();
        assertEquals(true, priorityQueue.isFull());
        testInsertEach();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIncreaseKeyWhenFull() {
        testInsertAll();
        assertEquals(true, priorityQueue.isFull());
        testIncreaseKey();
    }

    @Test
    public void testPop() {
        int[] output = new int[]{16, 14, 10, 9, 8, 7, 4, 3, 2, 1};
        testInsertAll();
        for (int i : output) {
            int max = priorityQueue.pop();
            assertEquals(i, max);
        }
    }

    @Test
    public void testIncreaseKey() {
        int[] expectedOutput = new int[]{16, 14, 10, 15, 7, 9, 3, 2, 8, 1};
        int[] output = priorityQueue.increaseKey(8, 15);
        assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testInsertEach() {
        int[] expectedResult = new int[priorityQueueSize];
        expectedResult[0] = 4;
        int[] result = priorityQueue.insert(4);
        assertArrayEquals(expectedResult, result);

        expectedResult[0] = 4;
        expectedResult[1] = 1;
        result = priorityQueue.insert(1);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsertAll() {
        int[] result = new int[priorityQueueSize];
        int[] output = new int[]{16, 14, 10, 8, 7, 3, 9, 1, 4, 2};
        for (int i : input) {
            result = priorityQueue.insert(i);
        }
        assertArrayEquals(output, result);
    }
}
