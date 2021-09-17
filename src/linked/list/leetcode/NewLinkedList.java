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
        this.size++;
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
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }
                newNode.next = current;
                previous.next = newNode;
            }
            this.size++;
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
            while (index++ < position) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        this.size--;
    }

    protected void removeByValue(int value) {
        int position = indexOf(value);
        removeByPosition(position);
    }

    protected int indexOf(int value) {
        Node current = this.head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1;
    }

    protected boolean hasElements() {
        return this.size > 0;
    }

    protected int size() {
        return this.size;
    }

    // 83. Remove Duplicates from Sorted List
    // Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    // Return the linked list sorted as well.
    protected Node removeDuplicates(Node head) {
        Node current = head;
        Node previous;
        while (current.next != null) {
            if (current.data == current.next.data) {
                previous = current;
                while (current.data == current.next.data) {
                    current = current.next;
                    this.size--;
                }
                previous.next = current;
                head = previous.next;
            }
            current = current.next;
        }
        return head;
    }

    // 203. Remove Linked List Elements
    // Given the head of a linked list and an integer val,
    // remove all the nodes of the linked list that has Node.val == val, and return the new head
    protected Node removeByNodeAndValue(Node head, int value) {
        int position = 0;
        while (position != -1 && head != null) {
            position = nodeIndexOf(head, value);
            head = removeByNodeAndPosition(head, position);
        }
        return head;
    }

    protected Node removeByNodeAndPosition(Node head, int position) {
        if (position >= 0) {
            Node current = head;
            // Remove head
            if (position == 0) {
                head = current.next;
            } else {
                Node previous = new Node();
                int index = 0;
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
            }
            this.size--;
        }
        return head;
    }

    protected int nodeIndexOf(Node head, int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1;
    }

    // 206. Reverse Linked List
    // Given the head of a singly linked list, reverse the list, and return the reversed list.
    protected Node reverseList(Node head) {
        if (head != null) {
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
        }
        return head;
    }

    // Iterative --> Review, it's too much complex solution
    protected Node iterativeReverseList(Node head) {
        if (head == null) return null;
        Node curr = head;
        Node temp = null;
        Node next = curr.next;
        while (curr != null) {
            // Break first node
            curr.next = temp;
            temp = curr;
            curr = next;
            next = (curr != null) ? curr.next : null;
        }
        return temp;
    }

    // Recursive --> Review, it's too much complex solution
    public Node recursiveReverseList(Node head) {
        if (head == null) return null;
        return solve(head, null, head.next);
    }

    private Node solve(Node curr, Node temp, Node next) {
        if (curr == null) return temp;
        curr.next = temp;
        temp = curr;
        curr = next;
        next = (curr != null) ? curr.next : null;
        return solve(curr, temp, next);
    }

}
