package ds.stack;

public class Stack {

    public static final int MAX_SIZE = 10;
    public int[] stack = new int[10];
    public int top = -1;

    public void push(int x) {
        stack[++ top] = x;
    }

    public int pop() {
        if (isEmpty()) return -1;
        return stack[top --];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return stack[top];
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }
}
