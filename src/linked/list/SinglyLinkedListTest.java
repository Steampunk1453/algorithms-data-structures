package linked.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinglyLinkedListTest {

    @Test
    void populateLinkedList() {
        // Given
        SinglyLinkedList linkedList = new SinglyLinkedList();
        // When
        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        // Then
        assertEquals(linkedList.head.data, 1);
        assertEquals(linkedList.head.next.data, 2);
        assertEquals(linkedList.head.next.data, 2);
        printList(linkedList);
    }

    @Test
    void deleteNode() {
        // Given
        SinglyLinkedList linkedList = new SinglyLinkedList();
        SinglyLinkedList.Node after = new SinglyLinkedList.Node();
        after.data = 2;
        // When
        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.deleteAfter(after);
        // Then
        assertEquals(linkedList.head.next.next.data, 4);
        printList(linkedList);
    }

    private void printList(SinglyLinkedList list) {
       SinglyLinkedList.Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

}