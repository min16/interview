package ds.queue;

public class LinkedListCircularQueue {

    public class ListNode {
        public ListNode(int x) {val = x;}
        public int val;
        public ListNode next;
    }

    public ListNode head = null;
    public ListNode tail = null;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return tail.val;
    }

    public void add(int x) {
        ListNode newNode = new ListNode(x);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public int remove() {
        if (isEmpty()) return -1;
        ListNode node = head;
        head = head.next;
        tail.next = head;
        return node.val;
    }
}
