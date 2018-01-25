package ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree;

    @Before
    public void SetUp() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testInsert() {
        assert(binarySearchTree.add(10));
        assert(binarySearchTree.add(2));
        assert(binarySearchTree.add(7));
        assert(binarySearchTree.add(46));
        assert(binarySearchTree.add(20));
        assert(!binarySearchTree.add(10));
    }

    @Test
    public void testInsertString() {
        assert(binarySearchTree.add("hello"));
        assert(binarySearchTree.add("1111"));
        assert(binarySearchTree.add("abc"));
        assert(!binarySearchTree.add("hello"));
        assert(!binarySearchTree.add("hello"));
        assert(binarySearchTree.add("10"));
        assert(binarySearchTree.add("100"));
    }

    @Test
    public void testGetNode() {
        testInsert();
        assert(binarySearchTree.contains(10));
        assert(!binarySearchTree.contains(22));
    }

    @Test
    public void testGetLeast() {
        binarySearchTree.add(10);
        binarySearchTree.add(2);
        BinarySearchTree.Node node7  = binarySearchTree.addValue(7);
        BinarySearchTree.Node node46 = binarySearchTree.addValue(46);
        BinarySearchTree.Node node20 = binarySearchTree.addValue(20);
        assertEquals(null, binarySearchTree.getLeast(node7));
        assertEquals(node20, binarySearchTree.getLeast(node46));
    }

    @Test
    public void testGetGreatest() {
        binarySearchTree.add(10);
        binarySearchTree.add(2);
        binarySearchTree.add(3);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        assertEquals(9, binarySearchTree.getGreatest(binarySearchTree.getNode(2)).value);
    }

    @Test
    public void testGetReplacementNode() {
        testInsert();
        assertEquals(20, binarySearchTree.getReplacementNode(binarySearchTree.getNode(10)).value);
        assertEquals(20, binarySearchTree.getReplacementNode(binarySearchTree.getNode(46)).value);
        assertEquals(null, binarySearchTree.getReplacementNode(binarySearchTree.getNode(20)));
    }

    @Test
    public void testRemoveRoot() {
        testInsert();
        assertEquals(10, binarySearchTree.remove(binarySearchTree.getNode(10).value));
    }

    @Test
    public void testRemoveNodeHasTwoChildren() {
        binarySearchTree.add(10);
        binarySearchTree.add(2);
        binarySearchTree.add(12);
        binarySearchTree.add(1);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        assertEquals(2, binarySearchTree.remove(binarySearchTree.getNode(2).value));
    }

    @Test
    public void testRemoveNodeHasNoChild() {
        binarySearchTree.add(10);
        binarySearchTree.add(2);
        binarySearchTree.add(12);
        assertEquals(12, binarySearchTree.remove(binarySearchTree.getNode(12).value));
    }

    @Test
    public void testSize() {
        testInsert();
        assertEquals(5, binarySearchTree.size());
        binarySearchTree.remove(binarySearchTree.getNode(10).value);
        assertEquals(4, binarySearchTree.size());
    }

    @Test
    public void testRotateLeft() {
        testInsert();
        binarySearchTree.add(50);
        binarySearchTree.add(51);
        binarySearchTree.add(23);
        binarySearchTree.rotateLeft(binarySearchTree.getNode(46));
    }

    @Test
    public void testRotateRight() {
        testInsert();
        binarySearchTree.add(50);
        binarySearchTree.add(51);
        binarySearchTree.add(23);
        binarySearchTree.rotateRight(binarySearchTree.getNode(46));
    }

    @After
    public void print() {
        System.out.println(binarySearchTree.getString());
    }
}
