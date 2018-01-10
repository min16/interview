package ds.queue;

public class Queue {

    public static final int MAX_SIZE = 10;
    public int[] queue = new int[MAX_SIZE];
    public int head = 0;
    public int tail = 0;

    public void add(int x) {
        if (isFull()) return;
        queue[tail ++] = x;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return queue[tail - 1];
    }

    public int remove() {
        if (isEmpty()) return -1;
        return queue[head ++];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail == MAX_SIZE - 1;
    }
}
