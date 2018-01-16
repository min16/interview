package ds.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {
    private PriorityQueue priorityQueue;
    int[] input = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    int[] output = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};

    @Before
    public void setUp() {
        priorityQueue = new PriorityQueue(input);
    }

    @Test
    public void testBuildMaxHeap() {
        assertArrayEquals(output, input);
    }

    @Test
    public void testGetMaximum() {
        int max = priorityQueue.maximum(input);
        assertEquals(output[0], max);
    }

    @Test
    public void testExtractMax() {
        priorityQueue.extractMax(input);
        int newMax = priorityQueue.maximum(input);
        assertEquals(output[1], newMax);
    }

    @Test
    public void testIncreaseKey() {
        int[] expectedOutput = new int[]{16, 14, 10, 15, 7, 9, 3, 2, 8, 1};
        int[] output = priorityQueue.increaseKey(input, 8, 15);
        assertArrayEquals(expectedOutput, output);
    }
}
