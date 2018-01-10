package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int arr[] = {12, 11, 13, 5, 6, 7};
        new MergeSort().sort(arr, 0, arr.length - 1);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 11, 12, 13}, arr);
    }
}
