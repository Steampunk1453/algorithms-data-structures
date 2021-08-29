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
    protected Node deleteNodes(int data) {
        Node current = head;
        // First iteration
        while (current.next != null) {
            current = current.next;
           if (current.data == data) {
               if (current.next != null) {
                   current.data = current.next.data;
                   if (current.next.next != null) {
                       current.next = current.next.next;
                   } else {
                       current.next = null;
                   }
               }
           }
        }
        // Second iteration to remove tail if tail node has data (val) to remove
        if (current.data == data) {
            Node temp = head;
            while (temp.next.data != data) {
                temp = temp.next;
            }
            temp.next = null;
        }
        // Remove if it's orphan
        if (head.next == null) {
            head = null;
        }
        return head;
    }


    protected Node removeElements(Node head, int val) {
        //check if current node/next node is null or current value is not target value
        if (head == null || (head.next == null && head.data != val)) return head;

        //recursive call to remove elements, returns list with elements removed
        Node ret = removeElements(head.next, val);

        //check if current node value is equal to target or not,
        //if yes break its next link, if no, assign the ret link to current node next
        if (head.data == val){
            head.next = null;
        } else{
            head.next = ret;
            ret = head;
        }

        //return the current node (will be head node of list)
        return ret;
    }

    // 206. Reverse Linked List
   // Given the head of a singly linked list, reverse the list, and return the reversed list.
    protected Node reverseList(Node head) {
        return null;
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
