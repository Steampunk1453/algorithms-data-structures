package linked.list.book;

import java.util.Stack;

public class Main {

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

    protected Node reverse() {
        Node current = this.head;
        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        this.head = new Node(stack.pop());
        current = this.head;

        while (!stack.isEmpty()) {
            int data = stack.pop();
            current.next = new Node(data);
            current = current.next;
        }
        return this.head;
    }

    protected Node reverseCopilot() {
        Node current = this.head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
        return this.head;
    }

}

