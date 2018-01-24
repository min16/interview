package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    protected Node<T> root = null;
    protected int size = 0;

    @Override
    public boolean add(T value) {
        if (this.contains(value)) return false;

        Node<T> addedNode = addValue(value);
        return addedNode != null;
    }

    @Override
    public boolean contains(T value) {
        Node<T> node = getNode(value);
        return node != null;
    }

    @Override
    public T remove(T value) {
        Node<T> nodeToRemove = removeValue(value);
        return nodeToRemove != null ? nodeToRemove.value : null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean validate() {
        return true;
    }

    protected String getString() {
        if (root == null) {
            return "Tree has no nodes.";
        }
        return getString(root, "", false);
    }

    protected Node<T> addValue(T value) {
        Node<T> newNode = createNewNode(null, value);

        if (root == null) {
            root = newNode;
            size ++;
            return newNode;
        }

        Node<T> node = root;
        while (node != null) {
            if (newNode.value.compareTo(node.value) <= 0) {
                // if newNode is small or equal
                if (node.left == null) {
                    node.left = newNode;
                    newNode.parent = node;
                    size ++;
                    return newNode;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    newNode.parent = node;
                    size ++;
                    return newNode;
                }
                node = node.right;
            }
        }

        return newNode;
    }

    protected Node<T> removeValue(T value) {
        Node<T> nodeToRemove = this.getNode(value);
        if (nodeToRemove != null) {
            nodeToRemove = removeNode(nodeToRemove);
        }
        return nodeToRemove;
    }

    protected Node<T> removeNode(Node<T> nodeToRemove) {
        Node<T> replacementNode = getReplacementNode(nodeToRemove);
        //replaceNodeWithNode(nodeToRemove, replacementNode);
        return nodeToRemove;
    }

    /*
        @param nodeToRemove
            Node<T> to remove from the tree.
        @return Node<T> which can be used to replace nodeToRemoved.
                nodeToRemove should NOT be NULL.
     */
    protected Node<T> getReplacementNode(Node<T> nodeToRemove) {
        Node<T> replacement = null;

        if (nodeToRemove.right != null && nodeToRemove.left != null) {
            // Two children.
            // Todo: use randomness to deletions.
            // find least node from right subtree
            replacement = getLeast(nodeToRemove.right);
            if (replacement == null) {
                replacement = nodeToRemove.right;
            }
        } else if (nodeToRemove.right != null && nodeToRemove.left == null) {
            // only right child
            replacement = nodeToRemove.right;
        } else if (nodeToRemove.left != null && nodeToRemove.right == null) {
            replacement = nodeToRemove.left;
        }
        return replacement;
    }

    protected Node<T> createNewNode(Node<T> parent, T value) {
        return new Node<>(parent, value);
    }

    /*
    * Get least node in sub-tree rooted at startingNode.
    *
    * @param startingNode
    *          Root of tree to search
    *
    * @return Node<T> which represents the least node in the startingNode
    * */
    protected Node<T> getLeast(Node<T> startingNode) {
        if (startingNode == null) {
            return null;
        }
        Node<T> left = startingNode.left;
        while (left != null && left.value != null) {
            Node<T> node = left.left;
            if (node != null && node.value != null) {
                left = node;
            } else {
                break;
            }
        }
        return left;
    }

    private String getString(Node<T> node, String prefix, boolean isTail) {
        StringBuilder builder = new StringBuilder();

        if (node.parent != null) {
            String side = "left";
            if (node.equals(node.parent.right)) {
                side = "right";
            }
            builder.append((isTail ? "└──" : "├──") + "(" + side + ")" + node.value + "\n");
        } else {
            builder.append((isTail ? "└──" : "├──") + node.value + "\n");
        }

        List<Node<T>> children = null;
        if (node.left != null || node.right != null) {
            children = new ArrayList<>(2);
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }

        if (children != null) {
            for (int i = 0; i < children.size() - 1; i ++) {
                builder.append(getString(children.get(i), prefix + (isTail ? "    " : "│   "), false));
            }
            if (children.size() >= 1) {
                builder.append(getString(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true));
            }
        }

        return builder.toString();
    }

    private Node<T> getNode(T value) {
        Node<T> node = root;

        while (node != null) {
            if (value.compareTo(node.value) < 0) {
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                node = node.right;
            } else if (value.compareTo(node.value) == 0) {
                return node;
            }
        }

        return null;
    }

    protected static class Node<T extends Comparable<T>> {
        protected T value = null;
        protected Node<T> parent = null;
        protected Node<T> left = null;
        protected Node<T> right = null;

        protected Node(Node<T> parent, T value) {
            this.parent = parent;
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value
                    + " parent=" + ((parent != null ) ? parent.value : "NULL")
                    + " left=" + ((left != null) ? left.value : "NULL")
                    + " right=" + ((right != null) ? right.value : "NULL");
        }
    }
}
