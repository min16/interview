package ds.stack;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListStackTest {
    public LinkedListStack stack = new LinkedListStack();

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testPush() {
        stack.push(1);
        Assert.assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testPop() {
        Assert.assertEquals(-1, stack.pop());
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(1);
        Assert.assertEquals(1, stack.peek());
        stack.push(2);
        Assert.assertEquals(2, stack.peek());
        stack.pop();
        Assert.assertEquals(1, stack.peek());
    }
}
