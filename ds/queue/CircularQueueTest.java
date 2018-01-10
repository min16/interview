package ds.queue;

import org.junit.Assert;
import org.junit.Test;

public class CircularQueueTest {
    public CircularQueue circularQueue = new CircularQueue();

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, circularQueue.isEmpty());
    }

    @Test
    public void testIsFull() {
        Assert.assertEquals(false, circularQueue.isFull());
        for (int i = 0; i < 9; i ++) { circularQueue.add(i); }
        Assert.assertEquals(true, circularQueue.isFull());
    }

    @Test
    public void testAdd() {
        circularQueue.add(1);
        Assert.assertEquals(false, circularQueue.isEmpty());
    }

    @Test
    public void testPeek() {
        circularQueue.add(1);
        Assert.assertEquals(1, circularQueue.peek());
        circularQueue.add(2);
        Assert.assertEquals(2, circularQueue.peek());
    }

    @Test
    public void testRemove() {
        circularQueue.add(1);
        circularQueue.add(2);
        Assert.assertEquals(1, circularQueue.remove());
        circularQueue.add(3);
        Assert.assertEquals(2, circularQueue.remove());
        Assert.assertEquals(3, circularQueue.remove());
    }
}