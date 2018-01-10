package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
    @Test
    public void testInsertionSort(){
        Assert.assertArrayEquals(new int[]{5, 6, 11, 12, 13}, new InsertionSort().insertionSort(new int[]{12, 11, 13, 5, 6}));
    }
}
