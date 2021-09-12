package linked.list.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewLinkedListTest {

    @Test
    void addNodes() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // Then
        assertEquals(linkedList.size, 3);
    }

    @Test
    void insertValues() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        boolean result = linkedList.insertElement(4, 10);
        // Then
        assertTrue(result);
        assertEquals(linkedList.size, 5);
        assertEquals(linkedList.indexOf(10), 4);
    }

    @Test
    void insertNotExistValue() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        boolean result = linkedList.insertElement(3, 10);
        // Then
        assertTrue(result);
        assertEquals(linkedList.size, 5);
        assertEquals(linkedList.indexOf(9), -1);
    }

    @Test
    void removeByPosition() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.removeByPosition(3);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(linkedList.indexOf(3), 2);
    }

    @Test
    void removeByValue() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.removeByValue(3);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(linkedList.indexOf(4), 2);
    }

    // 203. Remove Linked List Elements
    @Test
    void deleteNodes() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        NewLinkedList.Node head = linkedList.head;
        NewLinkedList.Node result = linkedList.removeByNodeAndValue(head, 6);
        // Then
        assertEquals(linkedList.size, 5);
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNodes1() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        NewLinkedList.Node head = linkedList.head;
        NewLinkedList.Node result = linkedList.removeByNodeAndValue(head, 1);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void deleteNodes2() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        NewLinkedList.Node head = linkedList.head;
        NewLinkedList.Node result = linkedList.removeByNodeAndValue(head, 7);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void reverseLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // Then
        linkedList.reverseList(linkedList.head);
        assertEquals(linkedList.head.data, 5);
    }

    @Test
    void reverseEmptyLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        // Then
        linkedList.reverseList(linkedList.head);
        assertEquals(linkedList.size, 0);
        assertNull(linkedList.head);
    }
    @Test
    void iterativeReverseLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // Then
        NewLinkedList.Node result = linkedList.iterativeReverseList(linkedList.head);
        assertEquals(result.data, 3);
    }

    @Test
    void recursiveReverseLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // Then
        NewLinkedList.Node result = linkedList.recursiveReverseList(linkedList.head);
        assertEquals(result.data, 3);
    }

}