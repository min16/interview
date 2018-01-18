package ds.queue;

import java.util.NoSuchElementException;

public class PriorityQueue {

    private int heapSize;
    private int[] arr;

    public PriorityQueue(int arrSize) {
        arr = new int[arrSize];
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return arr[0];
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int max = arr[0];
        swap(arr, 0, heapSize - 1);
        heapSize --;
        maxHeapify(heapSize, 0);
        return max;
    }

    /*
        i번째 노드에 새로운 key 삽입
        (현재 i번째 노드의 값보다 key가 같거나 커야함)
    */
    public int[] increaseKey(int i, int key) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        if (key < arr[i]) return arr;
        arr[i] = key;
        int parent = getParent(i);
        while (i > 0 && arr[parent] < arr[i]) {
            swap(arr, i, parent);
            i = parent;
            parent = getParent(i);
        }
        return arr;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == arr.length;
    }

    public int[] insert(int key) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        increaseKey(heapSize, key);
        heapSize ++;
        return arr;
    }

    private int getParent(int i) {
        return isEven(i) ? (i - 2) / 2 : (i - 1) / 2;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void maxHeapify(int n, int i) {
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
            maxHeapify(n, max);
        }
    }
}
