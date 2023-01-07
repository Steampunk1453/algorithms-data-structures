package linked.list.top;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}