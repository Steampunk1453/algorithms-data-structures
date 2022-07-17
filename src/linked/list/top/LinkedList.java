package linked.list.top;

import java.util.Stack;

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

    protected Node reverse(Node head) {
        Node current = head;
        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        head = new Node(stack.pop());
        current = head;

        while (!stack.isEmpty()) {
            int data = stack.pop();
            current.next = new Node(data);
            current = current.next;
        }
        return head;
    }

    // Set prev pointer to null
    // Set curr pointer to head
    // iterate over all the nodes 1 by 1 and point curr node to prev node
    // return the prev because curr node is null
    protected Node reverseIterative(Node head) {
        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    // Go to the last node recursively to fetch the head node
    // point current node's next node, next pointer to current node
    // i.e. 2->3 where 2 is curr and three is next, point curr node next node means 3's next pointer to 2
    // make the head next pointer null, for handling the 1st node scenario
    // finally return the head pointer which we fetched recursively
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

}

