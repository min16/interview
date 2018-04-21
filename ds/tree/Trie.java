package ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class Trie {
    private static final int MAX = 26;
    private static Trie root = new Trie();

    private Trie[] children;
    private boolean isWord;

    public Trie() {
        children = new Trie[MAX];
        for (int i = 0; i < MAX; i ++) {
            children[i] = null;
        }
        isWord = false;
    }

    public void insert(String word) {
        Trie node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean hasWord(String word) {
        Trie node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return node != null && node.isWord;
    }

    @Test
    public void test() {
        insert("hello");
        Assert.assertEquals(true, hasWord("hello"));
        Assert.assertEquals(false, hasWord("hell"));
    }
}
