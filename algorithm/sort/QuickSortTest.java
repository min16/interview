package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        Assert.assertArrayEquals(new int[]{10, 30, 40, 50, 70, 80, 90}, arr);
    }
}
