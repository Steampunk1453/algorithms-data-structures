package tree.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import tree.binary.BinaryTree.Node;

class BinaryTreeTest {

    @Test
    void addElement() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        // When
        binaryTree.add(8);
        binaryTree.add(4);
        binaryTree.add(10);
        binaryTree.add(6);
        binaryTree.add(20);
        binaryTree.add(2);
        // Then
        assertEquals(binaryTree.root.value, 8);
    }

    @Test
    void getNode() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(8);
        binaryTree.add(4);
        binaryTree.add(10);
        binaryTree.add(6);
        binaryTree.add(20);
        binaryTree.add(2);
        // When
        BinaryTree.Node result = binaryTree.getNode(binaryTree.root, 10);
        // Then
        assertEquals(result.value, 10);
    }

    @Test
    void getNodeReturnsNull() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(8);
        binaryTree.add(4);
        binaryTree.add(10);
        binaryTree.add(6);
        binaryTree.add(20);
        binaryTree.add(2);
        // When
        BinaryTree.Node result = binaryTree.getNode(binaryTree.root, 5);
        // Then
        assertNull(result);
    }


    @Test
    void removeNode() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        binaryTree.add(55);
        // When
        binaryTree.remove(50);
        // Then
        assertEquals(binaryTree.root.value, 52);
    }

    @Test
    void inOrderTraversal() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        binaryTree.inOrderTraversal(binaryTree.root);
        // Then
        assertEquals(binaryTree.root.value, 50);
    }

    @Test
    void inOrderTraversalIterative() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        List<Integer> result = binaryTree.inOrderTraversalIterative(binaryTree.root);
        // Then
        assertEquals(result.size(), 12);
        assertEquals(result.get(0), 11);
    }

    @Test
    void inOrderTraversalIterative1() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        List<Integer> result = binaryTree.inOrderTraversalIterative1(binaryTree.root);
        // Then
        assertEquals(result.size(), 12);
        assertEquals(result.get(0), 11);
    }

    @Test
    void preOrderTraversal() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        binaryTree.preOrderTraversal(binaryTree.root);
        // Then
        assertEquals(binaryTree.root.value, 50);
    }

    @Test
    void preOrderTraversalIterative() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        List<Integer> result = binaryTree.preOrderTraversalIterative(binaryTree.root);
        // Then
        assertEquals(result.size(), 12);
        assertEquals(result.get(0), 50);
    }

    @Test
    void preOrderTraversalIterative1() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        binaryTree.preOrderTraversalIterative1();
        // Then
        assertEquals(binaryTree.root.value, 50);
    }

    @Test
    void preOrderTraversalIterative2() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        List<Integer> result = binaryTree.preOrderTraversalIterative2(binaryTree.root);
        // Then
        assertEquals(result.size(), 12);
        assertEquals(result.get(0), 50);
    }

    @Test
    void postOrderTraversal() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        binaryTree.postOrderTraversal(binaryTree.root);
        // Then
        assertEquals(binaryTree.root.value, 50);
    }

    @Test
    void postOrderTraversalIterative() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        binaryTree.postOrderTraversalIterative();
        // Then
        assertEquals(binaryTree.root.value, 50);
    }

    @Test
    void postOrderTraversalList() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        List<Integer> result = binaryTree.postOrderTraversalList(binaryTree.root);
        // Then
        assertEquals(result.size(), 12);
        assertEquals(result.get(0), 11);
    }

    @Test
    void traverseLevelOrder() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        binaryTree.traverseLevelOrder(binaryTree.root);
        // Then
        assertEquals(binaryTree.root.value, 50);
    }


    @Test
    void traverseLevelOrderRecursive() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.root);
        // When
        binaryTree.traverseLevelOrderRecursive(binaryTree.root, queue);
        // Then
        assertEquals(binaryTree.root.value, 50);
    }

    @Test
    void isSameTree() {
        // Given
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.add(1);
        binaryTree1.add(2);
        binaryTree1.add(3);
        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.add(1);
        binaryTree2.add(2);
        binaryTree2.add(3);
        // When
        boolean result = binaryTree1.isSameTree2(binaryTree1.root, binaryTree2.root);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotSameTree() {
        // Given
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.add(1);
        binaryTree1.add(2);
        binaryTree1.add(3);
        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.add(5);
        binaryTree2.add(2);
        binaryTree2.add(3);
        // When
        boolean result = binaryTree1.isSameTree(binaryTree1.root, binaryTree2.root);
        // Then
        assertFalse(result);
    }


    @Test
    void maxDepth() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        int result = binaryTree.maxDepth(binaryTree.root);
        // Then
        assertEquals(result, 4);
    }

    @Test
    void sortedArrayToBST() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {-10,-3,0,5,9};
        // When
        BinaryTree.Node result = binaryTree.sortedArrayToBST(nums);
        // Then
        assertEquals(result.value, 0);
    }

    @Test
    void isBalancedBinaryTree() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(20);
        binaryTree.add(10);
        binaryTree.add(30);
        // When
        boolean result = binaryTree.isBalancedBinaryTree(binaryTree.root);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotBalancedBinaryTree() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(30);
        binaryTree.add(20);
        binaryTree.add(50);
        binaryTree.add(10);
        binaryTree.add(11);
        // When
        boolean result = binaryTree.isBalancedBinaryTree(binaryTree.root);
        // Then
        assertFalse(result);
    }

    @Test
    void minDepth() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        // When
        int result = binaryTree.minDepth(binaryTree.root);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void minDepth1() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        // When
        int result = binaryTree.minDepth(binaryTree.root);
        // Then
        assertEquals(result, 3);
    }


    @Test
    void hasPathSum() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        boolean result = binaryTree.hasPathSum(binaryTree.root, 138);
        // Then
        assertTrue(result);
    }

    @Test
    void notHasPathSum() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        boolean result = binaryTree.hasPathSum(binaryTree.root, 87);
        // Then
        assertFalse(result);
    }

    @Test
    void invertBinaryTree() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        BinaryTree.Node result = binaryTree.invertBinaryTree(binaryTree.root);
        // Then
        assertEquals(result.value, 50);
    }

    @Test
    void lowestCommonAncestor() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(8);
        binaryTree.add(0);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(3);
        binaryTree.add(5);
        // When
        BinaryTree.Node result = binaryTree.lowestCommonAncestor(binaryTree.root, 2, 8);
        // Then
        assertEquals(result.value, 6);
    }

    @Test
    void lowestCommonAncestorIterative() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(8);
        binaryTree.add(0);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(3);
        binaryTree.add(5);
        // When
        BinaryTree.Node result = binaryTree.lowestCommonAncestorIterative(binaryTree.root, 2, 4);
        // Then
        assertEquals(result.value, 2);
    }

    @Test
    void binaryTreePaths() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(8);
        binaryTree.add(0);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(3);
        binaryTree.add(5);
        // When
        List<String> result = binaryTree.binaryTreePaths(binaryTree.root);
        // Then
        assertEquals(result.size(), 5);
    }

    @Test
    void sumLeftLeaves() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(8);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(3);
        binaryTree.add(5);
        // When
        int result = binaryTree.sumLeftLeaves(binaryTree.root);
        // Then
        assertEquals(result, 11);
    }

    @Test
    void maxValue() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(75);
        binaryTree.add(11);
        binaryTree.add(33);
        binaryTree.add(61);
        binaryTree.add(89);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(52);
        binaryTree.add(82);
        binaryTree.add(95);
        // When
        Integer result = binaryTree.maxValue(binaryTree.root);
        // Then
        assertEquals(result, 95);
    }

    @Test
    void maxValue1() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(-2);
        binaryTree.add(0);
        binaryTree.add(3);
        binaryTree.add(9);
        binaryTree.add(8);
        binaryTree.add(6);
        // When
        Integer result = binaryTree.maxValue(binaryTree.root);
        // Then
        assertEquals(result, 9);
    }

    @Test
    void levelOrder() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(3);
        binaryTree.add(9);
        binaryTree.add(20);
        binaryTree.add(15);
        binaryTree.add(7);
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(List.of(3));
        expectedOutput.add(List.of(9));
        expectedOutput.add(Arrays.asList(7, 20));
        expectedOutput.add(List.of(15));
        // When
        List<List<Integer>> result = binaryTree.levelOrder(binaryTree.root);
        // Then
        assertEquals(expectedOutput, result);
    }

    @Test
    void levelOrder1() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(List.of(1));
        // When
        List<List<Integer>> result = binaryTree.levelOrder(binaryTree.root);
        // Then
        assertEquals(expectedOutput, result);
    }
    @Test
    void levelOrder2() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        List<List<Integer>> expectedOutput = new ArrayList<>();
        // When
        List<List<Integer>> result = binaryTree.levelOrder(binaryTree.root);
        // Then
        assertEquals(expectedOutput, result);
    }

    @Test
    void rightSideView() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(8);
        List<Integer> expected = Arrays.asList(5, 7, 8);
        // When
        List<Integer> result = binaryTree.rightSideView(binaryTree.root);
        // Then
        assertEquals(expected, result);
    }

    @Test
    void rightSideView1() {
        // Given
        BinaryTree binaryTree = new BinaryTree();
        List<Integer> expected = new ArrayList<>();
        // When
        List<Integer> result = binaryTree.rightSideView(binaryTree.root);
        // Then
        assertEquals(expected, result);
    }


}