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
    public void testGetReplacementNode() {

    }

    @After
    public void print() {
        System.out.println(binarySearchTree.getString());
    }
}
