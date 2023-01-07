package linked.list.top;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    protected void insert(int index, int value) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            this.head = newNode;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    protected int search(int value) {
        Node current = this.head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        return current != null ? current.data : 0;
    }

    protected void delete(int index) {
        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    protected void print() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    protected void printCopilot(Node node) {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    protected int tail() {
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

}

