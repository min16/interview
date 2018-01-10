package ds.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    public Stack stack = new Stack();

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testPeek() {
        stack.push(2);
        Assert.assertEquals(2, stack.peek());
    }

    @Test
    public void testPush() {
        stack.push(2);
        Assert.assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(3);
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void testIsFull() {
        for(int i = 0; i < 10; i ++) {
            stack.push(i);
        }
        Assert.assertEquals(true, stack.isFull());
    }
}