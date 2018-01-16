package ds.queue;

public class PriorityQueue {

    private int heapSize;

    public PriorityQueue(int[] arr) {
        heapSize = arr.length - 1;
        buildMaxHeap(arr);
    }

    public int maximum(int[] arr) {
        return arr[0];
    }

    public int extractMax(int[] arr) {
        int max = arr[0];
        swap(arr, 0, heapSize);
        heapSize --;
        maxHeapify(arr, heapSize, 0);
        return max;
    }

    /*
        i번째 노드에 새로운 key 삽입
        (현재 i번째 노드의 값보다 key가 같거나 커야함)
    */
    public int[] increaseKey(int[] arr, int i, int key) {
        if (key < arr[i]) return arr;
        arr[i] = key;
        int parent = getParent(i);
        while (i > 0 && arr[parent] < arr[i]) {
            swap(arr, i, parent);
            i = parent;
        }
        return arr;
    }

    public int[] insert(int[] arr, int key) {
        heapSize ++;
        increaseKey(arr, heapSize, key);
        return arr;
    }

    private int getParent(int i) {
        return isEven(i) ? (i - 2) / 2 : (i - 1) / 2;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
    private void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i --) {
            maxHeapify(arr, n, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void maxHeapify(int[] arr, int n, int i) {
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
            swap(arr, i, max);
            maxHeapify(arr, n, max);
        }
    }
}
