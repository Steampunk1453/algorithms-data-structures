package linked.list.leetcode;

import java.util.Stack;

public class NewLinkedList {

    Node head;
    int size = 0;

    static class Node {
        int data;
        Node next;
    }

    protected void appendElement(int val) {
        Node current = new Node();
        Node newNode = new Node();
        newNode.data = val;
        // List empty --> insert first element
        if (this.head == null) {
            this.head = newNode;
        } else {
            // List with data --> iterate over list
            current = this.head;
        }
        // With null we are in the tail of the list
        while (current.next != null) {
            current = current.next;
        }
        // Set new node to the final of the list
        current.next = newNode;
        // Increase list size
        this.size ++;
    }
    protected boolean insertElement(int position, int val) {
        // Insert in tail
        int lastPosition = this.size - 1;
        // Range validation
        if (position >= 0 && position <= this.size) {
            Node newNode = new Node();
            newNode.data = val;
            Node current = this.head;
            // Check is first element of the list
            if (position == 0) {
                newNode.next = current;
                this.head = newNode;
            } else {
                // Iterate the list to the indicated position
                Node previous = new Node();
                int index = 0;
                while (index ++ < position) {
                    previous = current;
                    current = current.next;
                }
                newNode.next = current;
                previous.next = newNode;
            }
            this.size ++;
            return true;
        }
        return false;
    }

    protected void removeByPosition(int position) {
        Node current = this.head;
        // Remove head
        if (position == 0) {
            this.head = current.next;
        } else {
            Node previous = new Node();
            int index = 0;
            while (index ++ < position) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        this.size --;
    }

    protected void removeByValue(int value) {
        int position = indexOf(value);
        removeByPosition(position);
    }

    protected int indexOf(int value) {
        Node current = this.head;
        int position = 0;
        while (current.next != null) {
            current = current.next;
            position ++;
            if (current.data == value) {
                return position;
            }
        }
        return -1;
    }

    protected boolean hasElements() {
        return this.size > 0;
    }

    protected int size() {
        return this.size;
    }


    // 206. Reverse Linked List
    // Given the head of a singly linked list, reverse the list, and return the reversed list.
    protected Node reverseList(Node head) {
        Node current = head;
        Stack<Integer> stack = new Stack<>();
        while (current.next != null) {
            stack.push(current.data);
            current = current.next;
        }
        stack.push(current.data);
        Node currentReverse = head;
        while (currentReverse.next != null) {
            currentReverse.data = stack.pop();
            currentReverse = currentReverse.next;
        }
        currentReverse.data = stack.pop();
        return head;
    }


}
