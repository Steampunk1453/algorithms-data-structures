package tree;

public class BinaryTree {

    protected Node root;

    static class Node {
        protected int value;
        protected Node left;
        protected Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    protected void add(int value) {
        this.root = addElement(this.root, value);
    }

    protected void remove(int value) {
        this.root = removeNode(this.root, value);
    }

    protected Node addElement(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        // left
        if (value < current.value) {
            current.left = addElement(current.left, value);
            // right
        } else if (value > current.value) {
            current.right = addElement(current.right, value);
        }
        return current;
    }

    protected Node getNode(Node current, int value) {
        if (value == current.value) {
            return current;
        } else if (value < current.value) {
            return current.left != null ? getNode(current.left, value) : null;
        }
        return current.right != null ? getNode(current.right, value) : null;
    }

    protected Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {

            if (current.left == null && current.right == null) {
                current = null;
            } else if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current = current.left;
            } else {
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = removeNode(current.right, smallestValue);
            }
        }

        // left
        else if (value < current.value) {
            current.left = removeNode(current.left, value);
            // right
        } else {
            current.right = removeNode(current.right, value);
        }

        return current;
    }

    protected void inOrderTraversal(Node current) {
        if (current != null) {
            inOrderTraversal(current.left);
            visit(current);
            inOrderTraversal(current.right);
        }
    }

    protected void preOrderTraversal(Node current) {
        if (current != null) {
            visit(current);
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

    protected void postOrderTraversal(Node current) {
        if (current != null) {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            visit(current);
        }
    }

    private void visit(Node current) {
        System.out.println(current.value);
    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }


}
