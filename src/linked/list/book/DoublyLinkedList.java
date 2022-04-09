package linked.list.book;

public class DoublyLinkedList {

    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
        }

    }

    protected void insert(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            newNode.previous = current;
            current.next = newNode;
        }
        this.tail = newNode;
    }

    protected void printReverse() {
        Node current = this.tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.previous;
        }
    }

}
