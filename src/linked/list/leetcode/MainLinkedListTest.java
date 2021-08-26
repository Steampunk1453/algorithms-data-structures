package linked.list.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainLinkedListTest {

    @Test
    void deleteNode() {
        // Given
        MainLinkedList linkedList = new MainLinkedList();
        MainLinkedList.Node node = new MainLinkedList.Node();
        node.data = 5;
        // When
        linkedList.insertFirstNode(4);
        linkedList.insertLastNode(5);
        linkedList.insertLastNode(1);
        linkedList.insertLastNode(9);
        linkedList.deleteNode(node);
        // Then
        assertEquals(linkedList.head.next.data, 1);
    }

    @Test
    void deleteNode1() {
        // Given
        MainLinkedList linkedList = new MainLinkedList();
        MainLinkedList.Node node = new MainLinkedList.Node();
        node.data = 0;
        // When
        linkedList.insertFirstNode(0);
        linkedList.insertLastNode(1);
        linkedList.deleteNode(node);
        // Then
        assertEquals(linkedList.head.data, 1);
    }
    @Test
    void deleteNode2() {
        // Given
        MainLinkedList linkedList = new MainLinkedList();
        MainLinkedList.Node node = new MainLinkedList.Node();
        node.data = -3;
        // When
        linkedList.insertFirstNode(-3);
        linkedList.insertLastNode(5);
        linkedList.insertLastNode(-99);
        linkedList.deleteNode(node);
        // Then
        assertEquals(linkedList.head.data, 5);
    }

    @Test
    void deleteNodes() {
        // Given
        MainLinkedList linkedList = new MainLinkedList();
        MainLinkedList.Node node = new MainLinkedList.Node();
        // When
        linkedList.insertFirstNode(1);
        linkedList.insertLastNode(2);
        linkedList.insertLastNode(6);
        linkedList.insertLastNode(3);
        linkedList.insertLastNode(4);
        linkedList.insertLastNode(5);
        linkedList.insertLastNode(6);
        linkedList.deleteNodes(6);
        // Then
        assertEquals(linkedList.head.next.next.data, 3);
    }

}