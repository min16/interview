package algorithm.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {
    private HeapSort heapSort;

    @Before
    public void setUp() {
        heapSort = new HeapSort();
    }

    @Test
    public void testSort() {
        int[] input = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int[] output = new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        heapSort.sort(input);
        assertArrayEquals(output, input);

        int[] input1 = new int[]{3, 19, 1, 14, 8, 7};
        int[] output1 = new int[]{1, 3, 7, 8, 14, 19};
        heapSort.sort(input1);
        assertArrayEquals(output1, input1);
    }

    @Test
    public void buildMaxHeap() {
        int[] input = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int[] output = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        int n = input.length;
        for (int i = n / 2; i >= 0; i --) {
            heapSort.maxHeapify(input, n, i);
        }
        assertArrayEquals(output, input);
    }

    //두번째 요소(4)가 heapify로 제자리를 찾는 테스트
    @Test
    public void testHeapify() {
        int[] input = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] output = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        heapSort.maxHeapify(input, input.length - 1, 1);
        assertArrayEquals(output, input);
    }
}
