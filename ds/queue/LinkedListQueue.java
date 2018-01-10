package ds.queue;

public class LinkedListQueue {
    public ListNode head = null;
    public ListNode tail = null;

    public class ListNode {
        public ListNode(int x) {val = x;}
        public int val;
        public ListNode next;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
    public void add(int x) {
        ListNode newNode = new ListNode(x);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int remove() {
        if (isEmpty()) return -1;
        ListNode node = head;
        head = head.next;
        return node.val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return tail.val;
    }
}
