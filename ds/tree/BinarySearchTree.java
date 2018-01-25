package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private int modifications = 0;

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
        return size;
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
        replaceNodeWithNode(nodeToRemove, replacementNode);
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
            // find least node from right subtree
            if (modifications % 2 != 0) {
                replacement = getLeast(nodeToRemove.right);
                if (replacement == null) {
                    replacement = nodeToRemove.right;
                }
            } else {
                replacement = getGreatest(nodeToRemove.left);
                if (replacement == null) {
                    replacement = nodeToRemove.left;
                }
            }
            modifications ++;
        } else if (nodeToRemove.right != null && nodeToRemove.left == null) {
            // only right child
            replacement = nodeToRemove.right;
        } else if (nodeToRemove.left != null && nodeToRemove.right == null) {
            replacement = nodeToRemove.left;
        }
        return replacement;
    }

    /*
    * Replace nodeToRemove with replacementNode in the tree.
    *
    * @param nodeToRemove
    *           Node<T> to remove and replace in the tree. nodeToRemove should
    *           NOT be NULL.
    * @param replacementNode
    *           Node<T> to replace nodeToRemove in the tree. replacementNode
    *           can be NULL.
    */
    protected void replaceNodeWithNode(Node<T> nodeToRemove, Node<T> replacementNode) {
        if (replacementNode != null) {

            // Replace replacementNode's branches with nodeToRemove's branches
            Node<T> nodeToRemoveLeft = nodeToRemove.left;
            if (nodeToRemoveLeft != null && nodeToRemoveLeft != replacementNode) {
                nodeToRemoveLeft.parent = replacementNode;
                replacementNode.left = nodeToRemoveLeft;
            }

            Node<T> nodeToRemoveRight = nodeToRemove.right;
            if (nodeToRemoveRight != null && nodeToRemoveRight != replacementNode) {
                nodeToRemoveRight.parent = replacementNode;
                replacementNode.right = nodeToRemoveRight;
            }

            // Remove link from replacementNode's parent to replacement
            Node<T> replacementParent = replacementNode.parent;
            if (replacementParent != null && replacementParent != nodeToRemove) {
                Node<T> replacementParentLeft = replacementParent.left;
                Node<T> replacementParentRight = replacementParent.right;
                if (replacementParentLeft != null && replacementParentLeft == replacementNode) {
                    replacementParent.left = replacementParentRight;
                    if (replacementParentRight != null) {
                        replacementParentRight.parent = replacementParent;
                    }
                } else if (replacementParentRight != null && replacementParentRight == replacementNode) {
                    replacementParent.right = replacementParentLeft;
                    if (replacementParentLeft != null) {
                        replacementParentLeft.parent = replacementParent;
                    }
                }
            }
        }

        // Update the link from the nodeToRemove to the replacementNode
        Node<T> parent = nodeToRemove.parent;
        if (parent == null) {
            root = replacementNode;
            if (root != null) {
                root.parent = null;
            }
        } else if (parent.left != null && parent.left == nodeToRemove) {
            parent.left = replacementNode;
            if (replacementNode != null) {
                replacementNode.parent = parent;
            }
        } else if (parent.right != null && parent.right == nodeToRemove) {
            parent.right = replacementNode;
            if (replacementNode != null) {
                replacementNode.parent = parent;
            }
        }

        size --;
    }

    protected void rotateLeft(Node<T> node) {
        Node<T> parent = node.parent;
        Node<T> right = node.right;
        Node<T> left = right.left;

        right.left = node;
        node.parent = right;

        node.right = left;

        if (left != null) {
            left.parent = node;
        }

        if (parent != null) {
            if (node == parent.left) {
                parent.left = right;
            } else if (node == parent.right) {
                parent.right = right;
            }
            right.parent = parent;
        } else {
            root = right;
            root.parent = null;
        }
    }

    protected void rotateRight(Node<T> node) {
        Node<T> parent = node.parent;
        Node<T> left = node.left;
        Node<T> right = left.right;

        left.right = node;
        node.parent = left;

        node.left = right;

        if (right != null) {
            right.parent = node;
        }

        if (parent != null) {
            if (node == parent.right) {
                parent.right = left;
            } else if (node == parent.left) {
                parent.left = left;
            }
            left.parent = parent;
        } else {
            root = left;
            root.parent = null;
        }
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

    protected Node<T> getGreatest(Node<T> startingNode) {
        if (startingNode == null) {
            return null;
        }
        Node<T> right = startingNode.right;
        while (right != null && right.value != null) {
            Node<T> node = right.right;
            if (node != null && node.value != null) {
                right = node;
            } else {
                break;
            }
        }
        return right;
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

    protected Node<T> getNode(T value) {
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
