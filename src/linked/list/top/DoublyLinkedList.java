package linked.list.top;

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

    public LinkedListExe.Node findTail(LinkedListExe.Node child){
        while(child.next != null){
            child=child.next;
        }
        return child;
    }

    // 430. Flatten a Multilevel Doubly Linked List
    // Time complexity: O(n)
    // Space complexity: O(1)
/*    protected Node flatten(Node head) {
        Node curr = head;
        while(curr!=null){
            if(curr.child != null){
                Node tail = findTail(curr.child);
                if(curr.next != null){
                    curr.next.prev=tail;
                }

                tail.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }*/

}
