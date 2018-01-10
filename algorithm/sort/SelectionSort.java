package algorithm.sort;

public class SelectionSort {
    public int[] selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i ++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < size; j ++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
