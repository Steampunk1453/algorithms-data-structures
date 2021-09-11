package linked.list.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(linkedList.size, 5);
    }

}