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
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        // When
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
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        // When
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
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        // When
        linkedList.removeByPosition(3);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(linkedList.indexOf(3), 2);
    }

    @Test
    void removeByValue() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        // When
        linkedList.removeByValue(3);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(linkedList.indexOf(4), 2);
    }

    // 83. Remove Duplicates from Sorted List
    @Test
    void removeDuplicates() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        // When
        NewLinkedList.Node head = linkedList.head;
        NewLinkedList.Node result = linkedList.removeDuplicates(head);
        // Then
        assertEquals(linkedList.size, 2);
        assertEquals(result.data, 1);
    }

    @Test
    void removeDuplicates1() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(3);
        // When
        NewLinkedList.Node head = linkedList.head;
        NewLinkedList.Node result = linkedList.removeDuplicates(head);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(result.data, 1);
    }

    // 203. Remove Linked List Elements
    @Test
    void deleteNodes() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        NewLinkedList.Node head = linkedList.head;
        // When
        NewLinkedList.Node result = linkedList.removeByNodeAndValue(head, 6);
        // Then
        assertEquals(linkedList.size, 5);
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNodes1() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        NewLinkedList.Node head = linkedList.head;
        // When
        NewLinkedList.Node result = linkedList.removeByNodeAndValue(head, 1);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void deleteNodes2() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        NewLinkedList.Node head = linkedList.head;
        // When
        NewLinkedList.Node result = linkedList.removeByNodeAndValue(head, 7);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void reverseLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        linkedList.reverseList(linkedList.head);
        // Then
        assertEquals(linkedList.head.data, 5);
    }

    @Test
    void reverseEmptyLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        // When
        linkedList.reverseList(linkedList.head);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(linkedList.head);
    }

    @Test
    void iterativeReverseLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        NewLinkedList.Node result = linkedList.iterativeReverseList(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void recursiveReverseLinkedList() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        NewLinkedList.Node result = linkedList.recursiveReverseList(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void getIntersectionNode() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        linkedList.appendElement(1);
        linkedList.appendElement(8);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(4);
        linkedList1.appendElement(1);
        linkedList1.appendElement(8);
        linkedList1.appendElement(4);
        linkedList1.appendElement(5);
        // When
        NewLinkedList.Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void getIntersectionNode1() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(3);
        linkedList1.appendElement(2);
        linkedList1.appendElement(4);
        // When
        NewLinkedList.Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 2);
    }

    @Test
    void getIntersectionNode2() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(4);
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(1);
        linkedList1.appendElement(5);
        // When
        NewLinkedList.Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertNull(result);
    }

    @Test
    void mergeTwoLists() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(1);
        linkedList1.appendElement(3);
        linkedList1.appendElement(4);
        // When
        NewLinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void mergeTwoLists1() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        linkedList.appendElement(7);
        linkedList.appendElement(8);
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(7);
        linkedList1.appendElement(8);
        linkedList1.appendElement(11);
        linkedList1.appendElement(12);
        // When
        NewLinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void mergeTwoLists2() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        linkedList.appendElement(3);
        linkedList.appendElement(7);
        linkedList.appendElement(8);
        linkedList.appendElement(10);
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(1);
        linkedList1.appendElement(4);
        linkedList1.appendElement(5);
        linkedList1.appendElement(7);
        // When
        NewLinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void mergeTwoLists3() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        NewLinkedList linkedList1 = new NewLinkedList();
        // When
        NewLinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertNull(result);
    }

    @Test
    void mergeTwoLists4() {
        // Given
        NewLinkedList linkedList = new NewLinkedList();
        NewLinkedList linkedList1 = new NewLinkedList();
        linkedList1.appendElement(0);
        // When
        NewLinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 0);
    }

}