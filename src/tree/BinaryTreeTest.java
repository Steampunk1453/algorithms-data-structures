package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    void getNode1() {
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
        // When
        binaryTree.remove( 50);
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
    void preOrderTraversal() {
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
        binaryTree.preOrderTraversal(binaryTree.root);
        // Then
        assertEquals(binaryTree.root.value, 50);
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

}