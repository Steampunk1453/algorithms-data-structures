package linked.list.old;

public class SinglyLinkedList {
    // TODO Mix between LinkedListExe and LinkedListOk classes

    Node head; // head of list

    static class Node {
        int data;
        Node next;
    }

    // used to insert a node at the start of linked list
    protected void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    // used to insert a node at the last of linked list
    protected void insertLast(int data) {
        Node current = head;
        while (current.next != null) {
            // we'll loop until current.next is null (traverse until last node)
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        // insert newNode
        current.next = newNode;
    }

    // used to delete node from start of linked list
    protected void deleteFirst() {
        Node temp = head;
        head = head.next;
    }

    // Use to delete node after particular node
    protected void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

}
