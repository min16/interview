package algorithm.sort;

public class HeapSort {

    /*
    *   1. max heap으로 만든다
    *   2. 루트노드와 마지막 노드를 교환한다.
    *   3. heap size를 줄이고 heapify로 만든다.
    *   4. heap size가 1개가 될때 까지 2번부터 다시 반복한다.
    */
    public int[] sort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 1; i --) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
        return arr;
    }

    //bottom-up 방식으로 unordered input array를 max-heap으로 만든다.
    public void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i --) {
            maxHeapify(arr, n, i);
        }
    }

    /*
    * n: heap size
    * i: root node
    */
    public void maxHeapify(int[] arr, int n, int i) {
        int max = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && arr[l] > arr[max]) {
            max = l;
        }
        if (r < n && arr[r] > arr[max]) {
            max = r;
        }
        if (max != i) {
            swap(arr, max, i);
            maxHeapify(arr, n, max);
        }
    }

    private void swap (int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
