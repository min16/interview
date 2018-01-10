package ds;

import ds.LinkedList.*;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList list = new LinkedList();

    @Test
    public void testGetSize() {
        Assert.assertEquals(0, list.getSize());
    }

    @Test
    public void testAdd() {
        ListNode firstNode = list.add(1);
        ListNode secondNode = list.add(2);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(1, firstNode.val);
        Assert.assertEquals(2, secondNode.val);
        Assert.assertEquals(secondNode, firstNode.next);
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);

        ListNode firstNode = list.remove(1);
        Assert.assertEquals(1, firstNode.val);
        Assert.assertEquals(1, list.getSize());

        ListNode secondNode = list.remove(2);
        Assert.assertEquals(2, secondNode.val);
        Assert.assertEquals(0, list.getSize());
    }
}