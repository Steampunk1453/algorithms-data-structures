package linked.list.top;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import linked.list.top.LinkedListExe.Node;
import org.junit.jupiter.api.Test;

class LinkedListExeTest {

    @Test
    void addNodes() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        // When
        Node head = linkedList.head;
        Node result = linkedList.removeDuplicatesFromSortedList(head);
        // Then
        assertEquals(linkedList.size, 2);
        assertEquals(result.data, 1);
    }

    @Test
    void removeDuplicates1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(3);
        // When
        Node head = linkedList.head;
        Node result = linkedList.removeDuplicatesFromSortedList(head);
        // Then
        assertEquals(linkedList.size, 3);
        assertEquals(result.data, 1);
    }

    // 203. Remove Linked List Elements
    @Test
    void deleteNodes() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        Node head = linkedList.head;
        // When
        Node result = linkedList.removeByNodeAndValue(head, 6);
        // Then
        assertEquals(linkedList.size, 5);
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNodes1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        Node head = linkedList.head;
        // When
        Node result = linkedList.removeByNodeAndValue(head, 1);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void deleteNodes2() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        linkedList.appendElement(7);
        Node head = linkedList.head;
        // When
        Node result = linkedList.removeByNodeAndValue(head, 7);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void reverseLinkedListFirst() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        Node result = linkedList.reverseFirst(linkedList.head);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void reverseLinkedListSecond() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        Node result = linkedList.reverseSecond(linkedList.head);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void reverseEmptyLinkedList() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        // When
        Node result = linkedList.reverseFirst(linkedList.head);
        // Then
        assertEquals(linkedList.size, 0);
        assertNull(result);
    }

    @Test
    void iterativeReverseLinkedListFirst() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        Node result = linkedList.iterativeReverseFirst(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void iterativeReverseLinkedListSecond() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        Node result = linkedList.iterativeReverseSecond(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void recursiveReverseLinkedListFirst() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        Node result = linkedList.recursiveReverseFirst(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void recursiveReverseLinkedListSecond() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        // When
        Node result = linkedList.recursiveReverseSecond(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void getIntersectionNode() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        linkedList.appendElement(1);
        linkedList.appendElement(8);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(4);
        linkedList1.appendElement(1);
        linkedList1.appendElement(8);
        linkedList1.appendElement(4);
        linkedList1.appendElement(5);
        // When
        Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void getIntersectionNode1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(3);
        linkedList1.appendElement(2);
        linkedList1.appendElement(4);
        // When
        Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 2);
    }

    @Test
    void getIntersectionNode2() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(2);
        linkedList.appendElement(6);
        linkedList.appendElement(4);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(1);
        linkedList1.appendElement(5);
        // When
        Node result = linkedList.getIntersectionNode(linkedList.head, linkedList1.head);
        // Then
        assertNull(result);
    }

    @Test
    void mergeTwoLists() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(1);
        linkedList1.appendElement(3);
        linkedList1.appendElement(4);
        // When
        Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void mergeTwoLists1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        linkedList.appendElement(7);
        linkedList.appendElement(8);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(7);
        linkedList1.appendElement(8);
        linkedList1.appendElement(11);
        linkedList1.appendElement(12);
        // When
        Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void mergeTwoLists2() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(3);
        linkedList.appendElement(7);
        linkedList.appendElement(8);
        linkedList.appendElement(10);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(1);
        linkedList1.appendElement(4);
        linkedList1.appendElement(5);
        linkedList1.appendElement(7);
        // When
        Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void mergeTwoLists3() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        LinkedListExe linkedList1 = new LinkedListExe();
        // When
        Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertNull(result);
    }

    @Test
    void mergeTwoLists4() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(0);
        // When
        Node result = linkedList.mergeTwoLists(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 0);
    }

    @Test
    void isPalindromeLinkedList() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        Node node = new Node();
        node.data = 5;

        // When
        Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 4);
    }

    @Test
    void deleteNode1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(1);
        linkedList.appendElement(9);
        Node node = new Node();
        node.data = 1;

        // When
        Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 4);
    }

    @Test
    void deleteNode2() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        Node node = new Node();
        node.data = 3;

        // When
        Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNode3() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(0);
        linkedList.appendElement(1);
        Node node = new Node();
        node.data = 0;

        // When
        Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void deleteNode4() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(-3);
        linkedList.appendElement(5);
        linkedList.appendElement(-99);
        Node node = new Node();
        node.data = -3;

        // When
        Node result = linkedList.deleteNode(node);
        // Then
        assertEquals(result.data, 5);
    }

    @Test
    void getMiddleNode() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        Node result = linkedList.middleNode(linkedList.head);
        // Then
        assertEquals(result.data, 3);
    }

    @Test
    void getMiddleNode1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        // When
        Node result = linkedList.middleNode(linkedList.head);
        // Then
        assertEquals(result.data, 4);
    }

    @Test
    void removeDuplicatesFromUnsortedList() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(1);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(2);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        // When
        Node result = linkedList.deleteDups(linkedList.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void removeDuplicatesFromUnsortedList1() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(1);
        linkedList.appendElement(3);
        linkedList.appendElement(2);
        // When
        Node result = linkedList.deleteDups(linkedList.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void getLastNode() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(1);
        linkedList.appendElement(2);
        linkedList.appendElement(3);
        linkedList.appendElement(4);
        linkedList.appendElement(5);
        linkedList.appendElement(6);
        // When
        Node result = linkedList.deleteMiddleNode(linkedList.head);
        // Then
        assertEquals(result.data, 1);
    }

    @Test
    void sumTwoList() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(7);
        linkedList.appendElement(1);
        linkedList.appendElement(6);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(5);
        linkedList1.appendElement(9);
        linkedList1.appendElement(2);
        // When
        Node result = linkedList.addTwoNumbers(linkedList.head, linkedList1.head);
        // Then
        assertEquals(result.data, 2);
    }

    @Test
    void isPalindromeList() {
        // Given
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
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
        LinkedListExe linkedList = new LinkedListExe();
        linkedList.appendElement(7);
        linkedList.appendElement(1);
        linkedList.appendElement(6);
        linkedList.appendElement(5);
        linkedList.appendElement(9);
        // When
        Node result = linkedList.getIntersectingNode(linkedList.head, linkedList.head.next.next);
        // Then
        assertEquals(result.data, 6);
    }

    @Test
    void getIntersectingNode1() {
        // Given
        LinkedListExe linkedListExe = new LinkedListExe();
        linkedListExe.appendElement(7);
        linkedListExe.appendElement(1);
        linkedListExe.appendElement(6);
        LinkedListExe linkedList1 = new LinkedListExe();
        linkedList1.appendElement(5);
        linkedList1.appendElement(9);
        linkedList1.appendElement(2);
        linkedList1.appendElement(2);
        linkedList1.appendElement(2);
        linkedList1.appendElement(2);
        // When
        LinkedListExe.Node result = linkedListExe.getIntersectingNode(linkedListExe.head, linkedList1.head.next);
        // Then
        assertNull(result);
    }

}