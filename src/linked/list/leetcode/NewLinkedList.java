package linked.list.leetcode;

import org.jetbrains.annotations.NotNull;

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

    // 21. Merge Two Sorted Lists
    // Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together
    // the nodes of the first two lists
    // This is because he's using Java and everything is considered an object here.
    // When he did tail = dummy, he stored the reference (pointer) for dummy variable into tail. Now every time the tail
    // variable is changed, it'd also affect the dummy variable
    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node();
        Node tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data > l2.data) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            tail.next =  l1;
        }

        if (l2 != null) {
            tail.next =  l2;
        }

        return dummy.next;
    }

    protected Node mergeTwoListsRecursive(Node l1, Node l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.data <= l2.data) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoListsRecursive(l1, l2.next);
        return l2;
    }

    // 83. Remove Duplicates from Sorted List
    // Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    // Return the linked list sorted as well.
    protected Node removeDuplicates(Node head) {
        if (head == null) return null;

        Node previous = head;
        Node current = head.next;

        while (current != null) {
            if (previous.data == current.data){
                //skipping the duplicate node
                current = current.next;
                this.size--;
            }
            else{
                // if not duplicates then make the link
                previous.next = current;
                previous = current;
                current = current.next;
            }
        }
        previous.next = current;
        return head;
    }

    // 160. Intersection of Two Linked Lists
    // Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    // If the two linked lists have no intersection at all, return null.
    // Could you write a solution that runs in O(n) time and use only O(1) memory
    protected Node getIntersectionNode(@NotNull Node headA, @NotNull Node headB) {
        Node headAOriginal = headA;

        while (headA != null && headB.next != null) {
            if (headA.data == headB.data && headA.next.data == headB.next.data) {
              return headA;
            }
            headA = headA.next;
        }
        headB = headB.next;

        if (headB == null) {
            return null;
        }

        return getIntersectionNode(headAOriginal, headB);
    }

    protected Node getIntersectionNodeSolution(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        Node A = headA;
        Node B = headB;
        while(A != B){
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
        }
        return A;
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

    // 234. Palindrome Linked List
    // Given the head of a singly linked list, return true if it is a palindrome
    protected boolean isPalindrome(Node head) {
        boolean result = false;
        Stack<Integer> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        current = head;
        while (current != null) {
            if (current.data == stack.pop()) {
                result = true;
            } else {
                return false;
            }
            current = current.next;
        }
        return result;
    }

    // 237. Delete Node in a Linked List
    // Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
    // instead you will be given access to the node to be deleted directly.
    // It is guaranteed that the node to be deleted is not a tail node in the list.
    protected Node deleteNode(Node node) {
        Node current = head;
        while (current.data != node.data) {
            current = current.next;
        }
        if (current.next != null) {
            current.data = current.next.data;
            current.next = current.next.next;
        }
        return head;
    }

    // 876. Middle of the Linked List
    protected Node getMiddleNode(Node node) {
        Node current = node;

        int size = 1;
        while (current != null) {
            current = current.next;
            size++;
        }

        int mediumIndex = size / 2;

        current = node;
        Node medium = new Node();

        int index = 0;
        while (current != null) {
            if (index == mediumIndex) {
                medium = current;
            }
            current = current.next;
            index++;
        }

        return medium;
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node middleNode1(Node head) {
        Node[] A = new Node[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

}
