package ds.queue;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListQueueTest {
    public LinkedListQueue queue = new LinkedListQueue();

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testAdd() {
        queue.add(1);
        Assert.assertEquals(false, queue.isEmpty());
    }

    @Test
    public void testRemove() {
        queue.add(1);
        queue.add(2);
        Assert.assertEquals(1, queue.remove());
        Assert.assertEquals(2, queue.remove());
    }

    @Test
    public void testPeek() {
        queue.add(1);
        Assert.assertEquals(1, queue.peek());
        queue.add(2);
        Assert.assertEquals(2, queue.peek());
    }
}
