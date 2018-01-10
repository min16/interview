package algorithm.sort;

public class QuickSort {
    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                //swap i, j
                swap(arr, i, j);
                i ++;
            }
        }
        // swap high and i
        swap(arr, i, high);
        return i;
    }
    public void swap (int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
