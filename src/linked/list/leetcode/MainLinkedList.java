package linked.list.leetcode;

public class MainLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
    }

    protected void insertFirstNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;

    }

    protected void insertLastNode(int data) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    // 203. Remove Linked List Elements
    // Given the head of a linked list and an integer val,
    // remove all the nodes of the linked list that has Node.val == val, and return the new head.
    protected void deleteNodes(int data) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
           if (current.data == data) {
               if (current.next != null) {
                   current.data = current.next.data;
                   if (current.next.next != null) {
                       current.next = current.next.next;
                   }
               }
           }
        }
    }

    // 237. Delete Node in a Linked List
    // Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
    // instead you will be given access to the node to be deleted directly.
    // It is guaranteed that the node to be deleted is not a tail node in the list.
    protected void deleteNode(Node node) {
        Node current = head;
        while (current.data != node.data) {
            current = current.next;
        }
        if (current.next != null) {
            current.data = current.next.data;
            current.next = current.next.next;
        }
        
    }

}
