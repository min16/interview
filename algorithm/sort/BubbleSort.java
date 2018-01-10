package algorithm.sort;

public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i = size - 1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[j + 1]) swap(arr, j);
            }
        }
        return arr;
    }

    public int[] swap (int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        return arr;
    }
}
