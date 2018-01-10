package ds.queue;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCircularQueueTest {
    public LinkedListCircularQueue linkedListCircularQueue = new LinkedListCircularQueue();

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, linkedListCircularQueue.isEmpty());
    }

    @Test
    public void testAdd() {
        linkedListCircularQueue.add(1);
        Assert.assertEquals(false, linkedListCircularQueue.isEmpty());
    }

    @Test
    public void testPeek() {
        linkedListCircularQueue.add(1);
        Assert.assertEquals(1, linkedListCircularQueue.peek());
        linkedListCircularQueue.add(2);
        Assert.assertEquals(2, linkedListCircularQueue.peek());
        linkedListCircularQueue.remove();
        Assert.assertEquals(2, linkedListCircularQueue.peek());
    }

    @Test
    public void testRemove() {
        linkedListCircularQueue.add(1);
        linkedListCircularQueue.add(2);
        Assert.assertEquals(1, linkedListCircularQueue.remove());
        linkedListCircularQueue.add(3);
        Assert.assertEquals(2, linkedListCircularQueue.remove());
        Assert.assertEquals(3, linkedListCircularQueue.remove());
    }
}
