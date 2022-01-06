package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

    protected void traverseLevelOrder(Node current) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(current);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            visit(node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
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
            } else {
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
    // 144. Binary Tree Preorder Traversal
    // O(n)
    private void preOrderTraversaList(Node root, List<Integer>result) {
        if(root != null) {
            result.add(root.value);
            preOrderTraversaList(root.left, result);
            preOrderTraversaList(root.right, result);
        }
    }

    protected List<Integer> preOrderTraversalIterative(Node root) {
        List<Integer> values = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                values.add(current.value);
                stack.push(current);
                current = current.left;
            } else {
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

    protected void postOrderTraversalIterative() {
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
    // 145. Binary Tree Postorder Traversal
    public List<Integer> postOrderTraversalList(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node>stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null){
                list.addFirst(current.value);
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            current = current.left;
        }

        return list;
    }

    // 100. Same Tree
    // Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    // Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    // O(n)
    protected boolean isSameTree(Node root1, Node root2) {
        if (root2 != null) {
            isSameTree(root1, root2.left);
            if (isPresent(root1, root2.value)) {
                isSameTree(root1, root2.right);
            } else {
                return false;
            }

        }
        return true;
    }

    private boolean isPresent(Node current, int value) {
        if (current.value == value) {
            return true;
        } else if (value < current.value) {
            return current.left != null && isPresent(current.left, value);
        } else {
            return current.right != null && isPresent(current.right, value);
        }
    }

    // O(n)
    protected boolean isSameTree1(Node p, Node q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.value != q.value) return false;
        return isSameTree1(p.right, q.right) && isSameTree1(p.left, q.left);
    }

    public boolean isSameTree2(Node p, Node q) {
        Deque<Node> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();

            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.value != q.value) return false;

            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }
        return true;
    }

    // O(n)
    protected boolean isSameTree3(Node p, Node q) {
        if (p == null && q == null) return true;
        if (check(p, q)) return false;

        // init deques
        ArrayDeque<Node> deqP = new ArrayDeque<>();
        ArrayDeque<Node> deqQ = new ArrayDeque<>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (check(p, q)) return false;
            // in Java nulls are not allowed in Deque
            if (check(p.left, q.left)) return false;
            if (p.left != null) {
                deqP.addLast(p.left);
                deqQ.addLast(q.left);
            }
            if (check(p.right, q.right)) return false;
            if (p.right != null) {
                deqP.addLast(p.right);
                deqQ.addLast(q.right);
            }
        }
        return true;
    }

    private boolean check(Node p, Node q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        return p.value == q.value;
    }

//    private boolean check(Node p, Node q) {
//        // p and q are null
//        if (p == null && q == null) return true;
//        // one of p and q is null
//        if (q == null || p == null) return false;
//        if (p.value != q.value) return false;
//        return true;
//    }

    // 101. Symmetric Tree
    // Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    protected boolean symmetricTree(Node root) {
        return isSymmetricTree(root.left, root.right);
    }

    protected boolean isSymmetricTree(Node left, Node right) {
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        if (right.value == left.value) {
            return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
        } else {
            return false;
        }
    }

    // 104. Maximum Depth of Binary Tree
    // Given the root of a binary tree, return its maximum depth.
    // A binary tree's maximum depth is the number of nodes along
    // the longest path from the root node down to the farthest leaf node.
    protected int maxDepth(Node root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    protected int maxDepth1(Node root) {
        if (root == null) return 0;
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    protected int maxDepth2(Node root) {
        // Root being null means tree doesn't exist.
        if (root == null)
            return 0;
        // Get the depth of the left and right subtree
        // using recursion.
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);

        // Choose the larger one and add the root to it.
        if (leftDepth > rightDepth)
            return (leftDepth + 1);
        else
            return (rightDepth + 1);
    }

    // 108. Convert Sorted Array to Binary Search Tree
    // Given an integer array nums where the elements are sorted in ascending order,
    // convert it to a height-balanced binary search tree.
    // A height-balanced binary tree is a binary tree in which the depth of the
    // two subtrees of every node never differs by more than one.
    protected Node sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return createBinaryTree(nums, start, end);
    }

    private Node createBinaryTree(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);

        node.left = createBinaryTree(array, start, mid - 1);
        node.right = createBinaryTree(array, mid + 1, end);

        return node;
    }

    // 110. Balanced Binary Tree
    // Given a binary tree, determine if it is height-balanced.
    // For this problem, a height-balanced binary tree is defined as:
    // a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
    protected boolean isBalancedBinaryTree(Node root) {
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        int result = Math.max(left, right) - Math.min(left, right);
        return result <= 1;
    }

    protected int depth(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    // 111. Minimum Depth of Binary Tree
    // Given a binary tree, find its minimum depth.
    // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    // Note: A leaf is a node with no children.
    protected int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // 112. Path Sum
    // Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
    // that adding up all the values along the path equals targetSum
    // A leaf is a node with no children
    protected boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.value == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.value) || hasPathSum(root.right, targetSum - root.value);
    }

}


