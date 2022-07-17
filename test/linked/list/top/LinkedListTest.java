package linked.list.top;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    @Test
    void insert() {
        // Given
        LinkedList linkedList = new LinkedList();
        // When
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        // Then
        Assertions.assertEquals(1, linkedList.head.data);

    }

    @Test
    void search() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        // When
        int result = linkedList.search(2);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void delete() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        // When
        linkedList.delete(0);
        // Then
        Assertions.assertEquals(2, linkedList.head.data);
    }

    @Test
    void print() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        // When
        linkedList.print();
        // Then
        Assertions.assertEquals(1, linkedList.head.data);
    }

    @Test
    void tail() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        // When
        int result = linkedList.tail();
        // Then
        assertEquals(result, 3);
    }
    @Test
    void reverse() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        linkedList.insert(3, 4);
        // When
        LinkedList.Node result = linkedList.reverse(linkedList.head);
        // Then
        Assertions.assertEquals(result.data, 4);
    }

    @Test
    void reverseIterative() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        linkedList.insert(3, 4);
        // When
        LinkedList.Node result = linkedList.reverseIterative(linkedList.head);
        // Then
        Assertions.assertEquals(result.data, 4);
    }

    @Test
    void reverseRecursive() {
        // Given
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 2);
        linkedList.insert(2, 3);
        linkedList.insert(3, 4);
        // When
        LinkedList.Node result = linkedList.reverseRecursive(linkedList.head);
        // Then
        Assertions.assertEquals(result.data, 4);
    }

}