package linked.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addNodes() {
        // Given
        LinkedList linkedList = new LinkedList();
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
        LinkedList linkedList = new LinkedList();
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
        LinkedList linkedList = new LinkedList();
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
        LinkedList linkedList = new LinkedList();
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
        LinkedList linkedList = new LinkedList();
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
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        // When
        LinkedList.Node head = linkedList.head;
        LinkedList.Node result = linkedList.removeDuplicatesFromSortedList(head);
        // Then
        assertEquals(linkedList.size, 2);
        assertEquals(result.data, 1);
    }

    @Test
    void removeDuplicates1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(3);
        // When
        LinkedList.Node head = linkedList.head;
        LinkedList.Node result = linkedList.removeDuplicatesFromSortedList(head);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(result.data, 1);
    }

    // 203. Remove Linked List Elements
    @Test
    void deleteNodes() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        LinkedList.Node head = linkedList.head;
        // When
        LinkedList.Node result = linkedList.removeByNodeAndValue(head, 6);
        // Then
        assertEquals(linkedList.size, 5);
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNodes1() {
        // Given
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head;
        // When
        LinkedList.Node result = linkedList.removeByNodeAndValue(head, 1);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void deleteNodes2() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        LinkedList.Node head = linkedList.head;
        // When
        LinkedList.Node result = linkedList.removeByNodeAndValue(head, 7);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void reverseLinkedList() {
        // Given
        LinkedList linkedList = new LinkedList();
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
        LinkedList linkedList = new LinkedList();
        // When
        linkedList.reverseList(linkedList.head);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(linkedList.head);
    }

    @Test
    void iterativeReverseLinkedList() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        LinkedList.Node result = linkedList.iterativeReverseList(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void recursiveReverseLinkedList() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        LinkedList.Node result = linkedList.recursiveReverseList(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void getIntersectionNode() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        linkedList.appendElement(1);
        linkedList.appendElement(8);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(4);
        linkedList1.appendElement(1);
        linkedList1.appendElement(8);
        linkedList1.appendElement(4);
        linkedList1.appendElement(5);
        // When
        LinkedList.Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void getIntersectionNode1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(3);
        linkedList1.appendElement(2);
        linkedList1.appendElement(4);
        // When
        LinkedList.Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 2);
    }

    @Test
    void getIntersectionNode2() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(4);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(1);
        linkedList1.appendElement(5);
        // When
        LinkedList.Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertNull(result);
    }

    @Test
    void mergeTwoLists() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(1);
        linkedList1.appendElement(3);
        linkedList1.appendElement(4);
        // When
        LinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void mergeTwoLists1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        linkedList.appendElement(7);
        linkedList.appendElement(8);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(7);
        linkedList1.appendElement(8);
        linkedList1.appendElement(11);
        linkedList1.appendElement(12);
        // When
        LinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void mergeTwoLists2() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(3);
        linkedList.appendElement(7);
        linkedList.appendElement(8);
        linkedList.appendElement(10);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(1);
        linkedList1.appendElement(4);
        linkedList1.appendElement(5);
        linkedList1.appendElement(7);
        // When
        LinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void mergeTwoLists3() {
        // Given
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList1 = new LinkedList();
        // When
        LinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertNull(result);
    }

    @Test
    void mergeTwoLists4() {
        // Given
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(0);
        // When
        LinkedList.Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 0);
    }

    @Test
    void isPalindromeLinkedList() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(2);
        linkedList.appendElement(1);
        // When
        boolean result = linkedList.isPalindrome(linkedList.head);
        // Then
        assertTrue(result);
    }

    @Test
    void isPalindromeLinkedList1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        // When
        boolean result = linkedList.isPalindrome(linkedList.head);
        // Then
        assertFalse(result);
    }

    @Test
    void deleteNode() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        LinkedList.Node node = new LinkedList.Node();
        node.data = 5;

        // When
        LinkedList.Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 4);
    }

    @Test
    void deleteNode1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        LinkedList.Node node = new LinkedList.Node();
        node.data = 1;

        // When
        LinkedList.Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 4);
    }

    @Test
    void deleteNode2() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        LinkedList.Node node = new LinkedList.Node();
        node.data = 3;

        // When
        LinkedList.Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNode3() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(0);
        linkedList.appendElement(1);
        LinkedList.Node node = new LinkedList.Node();
        node.data = 0;

        // When
        LinkedList.Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNode4() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(-3);
        linkedList.appendElement(5);
        linkedList.appendElement(-99);
        LinkedList.Node node = new LinkedList.Node();
        node.data = -3;

        // When
        LinkedList.Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void getMiddleNode() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        LinkedList.Node result = linkedList.middleNode(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void getMiddleNode1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        // When
        LinkedList.Node result = linkedList.middleNode(linkedList.head);
        // Then
        assertEquals(result.data, 4);
    }

    @Test
    void removeDuplicatesFromUnsortedList() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(1);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        LinkedList.Node result = linkedList.deleteDups(linkedList.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void removeDuplicatesFromUnsortedList1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(1);
        linkedList.appendElement(3);
        linkedList.appendElement(2);
        // When
        LinkedList.Node result = linkedList.deleteDups(linkedList.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void getLastNode() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        // When
        int result = linkedList.getLastNodeIndex(linkedList.head);
        // Then
        assertEquals(result, 6);
    }

    @Test
    void getLastNode1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        // When
        int result = linkedList.printKthToLast(linkedList.head, 6);
        // Then
        assertEquals(result, 6);
    }

    @Test
    void deleteMiddleNode() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        // When
        LinkedList.Node result = linkedList.deleteMiddleNode(linkedList.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void sumTwoList() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(7);
        linkedList.appendElement(1);
        linkedList.appendElement(6);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(5);
        linkedList1.appendElement(9);
        linkedList1.appendElement(2);
        // When
        LinkedList.Node result = linkedList.addTwoNumbers(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 2);
    }

    @Test
    void isPalindromeList() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(0);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(1);
        linkedList.appendElement(0);
        // When
        boolean result = linkedList.isPalindromeList(linkedList.head);
        // Then
        assertTrue(result);
    }

    @Test
    void isPalindromeList1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        // When
        boolean result = linkedList.isPalindromeList(linkedList.head);
        // Then
        assertFalse(result);
    }

    @Test
    void getIntersectingNode() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(7);
        linkedList.appendElement(1);
        linkedList.appendElement(6);
        linkedList.appendElement(5);
        linkedList.appendElement(9);
        // When
        LinkedList.Node result = linkedList.getIntersectingNode(linkedList.head, linkedList.head.next.next);
        // Then
        assertEquals(result.data, 6);
    }

    @Test
    void getIntersectingNode1() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.appendElement(7);
        linkedList.appendElement(1);
        linkedList.appendElement(6);
        LinkedList linkedList1 = new LinkedList();
        linkedList1.appendElement(5);
        linkedList1.appendElement(9);
        linkedList1.appendElement(2);
        linkedList1.appendElement(2);
        linkedList1.appendElement(2);
        linkedList1.appendElement(2);
        // When
        LinkedList.Node result = linkedList.getIntersectingNode(linkedList.head, linkedList1.head.next);
        // Then
        assertNull(result);
    }

}