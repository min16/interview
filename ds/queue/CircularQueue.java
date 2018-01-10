package ds.queue;

public class CircularQueue {
    public static final int MAX_SIZE = 10;
    public int[] circularQueue = new int[MAX_SIZE];
    public int head = 0;
    public int tail = 0;

    public void add(int x) {
        if (isFull()) return;
        circularQueue[tail] = x;
        tail = (tail + 1) % MAX_SIZE;
    }

    public int remove() {
        if (isEmpty()) return -1;
        int removeNum = circularQueue[head];
        head = (head + 1) % MAX_SIZE;
        return removeNum;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % MAX_SIZE == head;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return circularQueue[(tail - 1) % MAX_SIZE];
    }
}

