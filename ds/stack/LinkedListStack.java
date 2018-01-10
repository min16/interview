package ds.stack;

public class LinkedListStack {
    public ListNode head  = null;

    public class ListNode {
        public ListNode(int x) {val = x;}
        public int val;
        public ListNode next;
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (isEmpty()) return -1;
        ListNode node = head;
        head = head.next;
        return node.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return head.val;
    }
}
