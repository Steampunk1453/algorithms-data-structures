package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
            visit(current.value);
            inOrderTraversal(current.right);
        }
    }

    protected void preOrderTraversal(Node current) {
        if (current != null) {
            visit(current.value);
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

    protected void postOrderTraversal(Node current) {
        if (current != null) {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            visit(current.value);
        }
    }

    private void visit(int value) {
        System.out.println(value);
    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }

    // 94. Binary Tree Inorder Traversal
    // Given the root of a binary tree, return the inorder traversal of its nodes' values.
    // Follow up: Recursive solution is trivial, could you do it Iterative?

    // O(n)
    protected List<Integer> inOrderTraversalIterative(Node root) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }  else {
                current = stack.pop();
                values.add(current.value);
                current = current.right;
            }
        }
        return values;
    }

    // O(n2)
    protected List<Integer> inOrderTraversalIterative1(Node root) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            values.add(current.value);
            current = current.right;
        }
        return values;
    }

    // O(n)
    protected List<Integer> preOrderTraversalIterative(Node root) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                values.add(current.value);
                stack.push(current);
                current = current.left;
            }  else {
                current = stack.pop();
                current = current.right;
            }
        }
        return values;
    }

    public void preOrderTraversalIterative1() {
        Stack<Node> stack = new Stack<>();
        Node current;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    // O(n2)
    protected List<Integer> preOrderTraversalIterative2(Node root) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                values.add(current.value);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }

        return values;
    }

    protected void potsOrderTraversalIterative() {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

}
