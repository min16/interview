package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSwap() {
        Assert.assertArrayEquals(new int[]{1, 2, 3}, new SelectionSort().swap(new int[]{3, 2, 1}, 0, 2));
    }

    @Test
    public void testSelectionSort() {
        Assert.assertArrayEquals(new int[]{11, 12, 22, 25, 64}, new SelectionSort().selectionSort(new int[]{64, 25, 12, 22, 11}));
        Assert.assertArrayEquals(new int[]{1, 3, 12, 14, 17}, new SelectionSort().selectionSort(new int[]{17, 3, 12, 14, 1}));
    }

}
