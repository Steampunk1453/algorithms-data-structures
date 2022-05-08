package linked.list.old;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OldLinkedListTest {

    @Test
    void deleteNode() {
        // Given
        OldLinkedList linkedList = new OldLinkedList();
        OldLinkedList.Node node = new OldLinkedList.Node();
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
        OldLinkedList linkedList = new OldLinkedList();
        OldLinkedList.Node node = new OldLinkedList.Node();
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
        OldLinkedList linkedList = new OldLinkedList();
        OldLinkedList.Node node = new OldLinkedList.Node();
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
        OldLinkedList linkedList = new OldLinkedList();
        // When
        linkedList.insertFirstNode(1);
        linkedList.insertLastNode(2);
        linkedList.insertLastNode(6);
        linkedList.insertLastNode(3);
        linkedList.insertLastNode(4);
        linkedList.insertLastNode(5);
        linkedList.insertLastNode(6);
        OldLinkedList.Node result = linkedList.deleteNodes(6);
        // Then
        assertEquals(result.next.next.data, 3);
    }

    @Test
    void deleteNodes1() {
        // Given
        OldLinkedList linkedList = new OldLinkedList();
        // When
        linkedList.insertFirstNode(7);
        linkedList.insertLastNode(7);
        linkedList.insertLastNode(7);
        linkedList.insertLastNode(7);
        OldLinkedList.Node result = linkedList.deleteNodes(7);
        // Then
        assertNull(result);
    }

}