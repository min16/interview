package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void testSwap() {
        Assert.assertArrayEquals(new int[]{1,2}, new BubbleSort().swap(new int[]{2, 1}, 0));
    }

    @Test
    public void testBubbleSort() {
        Assert.assertArrayEquals(new int[]{1, 2, 4, 5, 8}, new BubbleSort().bubbleSort(new int[]{5, 1, 4, 2, 8}));
    }
}
