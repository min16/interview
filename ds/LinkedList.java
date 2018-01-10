package ds;

public class LinkedList {

    private ListNode head;

    public class ListNode {
        public ListNode(int x) {val = x;}
        public int val;
        public ListNode next;
    }

    // 값이 x인 ListNode 추가
    public ListNode add(int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head = newNode;
            return head;
        }

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return newNode;
    }

    // 값이 x인 ListNode 삭제
    public ListNode remove(int x) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;

        // head가  x 일 경우
        if (head != null && curr.val == x) {
            head = curr.next;
            return curr;
        }

        while (curr != null && curr.val != x) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return null;

        prev.next = curr.next;

        return curr;
    }

    // 갯수 리턴
    public int getSize() {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len ++;
            curr = curr.next;
        }

        return len;
    }
}
