package linked.list.top;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;

public class LinkedListExe {

    Node head;
    int size = 0;

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
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
            tail.next = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }

    protected Node mergeTwoListsRecursive(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

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
    protected Node removeDuplicatesFromSortedList(Node head) {
        if (head == null) {
            return null;
        }

        Node previous = head;
        Node current = head.next;

        while (current != null) {
            if (previous.data == current.data) {
                //skipping the duplicate node
                current = current.next;
                this.size--;
            } else {
                // if not duplicates then make the link
                previous.next = current;
                previous = current;
                current = current.next;
            }
        }
        previous.next = current;
        return head;
    }

    // 92. Reverse Linked List II
    // Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes
    // of the list from position left to position right, and return the reversed list
    protected Node reverseBetween(Node head, int left, int right) {
        int m = left, n = right;

        /*  Corner Case */
        if (head == null || head.next == null || m <= 0 || n <= 0 || m == n) {
            return head;
        }

        // to store the head index, to return the final updated head at this index.
        Node preHead = new Node(0);
        preHead.next = head;

        // Traverse the list till position m. Position m -> index m-1 => loop till 0 to m-2.
        Node prev = preHead;

        for (int i = 0; i <= m - 2; i++) {
            prev = prev.next;
        }

        // Reverse the list from position m to n.
        Node curr = prev.next;
        Node temp;

        Node reverseHead = null;

        for (int i = 0; i <= n - m; i++) {
            temp = curr.next;         // save next of current for next iteration
            curr.next = reverseHead;  // reset current to point back not forward

            reverseHead = curr;       // make current as head of new reverseHead list
            curr = temp;              // move to next node
        }

        // Connect the reversed list with the prev node (position m-1)
        prev.next.next = curr;
        prev.next = reverseHead;

        return preHead.next;
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
        if (headA == null || headB == null) {
            return null;
        }
        Node A = headA;
        Node B = headB;
        while (A != B) {
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
    protected Node reverseFirst(Node head) {
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

    protected Node reverseSecond(Node head) {
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

    // Iterative --> Review, it's too much complex solution
    protected Node iterativeReverseFirst(Node head) {
        if (head == null) {
            return null;
        }
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

    // Set prev pointer to null
    // Set curr pointer to head
    // iterate over all the nodes 1 by 1 and point curr node to prev node
    // return the prev because curr node is null
    protected Node iterativeReverseSecond(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    // Recursive --> Review, it's too much complex solution
    public Node recursiveReverseFirst(Node head) {
        if (head == null) {
            return null;
        }
        return solve(head, null, head.next);
    }

    private Node solve(Node curr, Node temp, Node next) {
        if (curr == null) {
            return temp;
        }
        curr.next = temp;
        temp = curr;
        curr = next;
        next = (curr != null) ? curr.next : null;
        return solve(curr, temp, next);
    }

    // Go to the last node recursively to fetch the head node
    // point current node's next node, next pointer to current node
    // i.e. 2->3 where 2 is curr and three is next, point curr node next node means 3's next pointer to 2
    // make the head next pointer null, for handling the 1st node scenario
    // finally return the head pointer which we fetched recursively
    public Node recursiveReverseSecond(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = recursiveReverseSecond(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
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
    // instead you will be given access to the node to be deleted directl,y.
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

    // The "Runner" Technique or second pointer
    protected Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Rearrange CCI --> p. 93
//        fast = head;
//        while (fast != null) {
//            fast.next = slow;
//            fast = fast.next.next;
//        }

        return slow;
    }

    protected Node middleNode1(Node head) {
        Node[] A = new Node[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    // 2.1 Remove Dups! Write code to remove duplicates from an unsorted linked list
    protected Node removeDuplicatesFromUnsortedList(Node head) {
        Node current = head;
        Hashtable<Integer, Integer> table = new Hashtable<>();

        while (current != null) {
            int index = 1;
            if (table.containsKey(current.data)) {
                index += 1;
            }
            table.put(current.data, index);
            current = current.next;
        }

        current = head;
        Node previous = null;
        boolean flag = false;
        while (current != null) {
            if (table.get(current.data) == 2) {
                if (previous.data == head.data) {
                    flag = true;
                }
                previous.next = current.next;
                table.put(current.data, 1);
            }
            previous = current;
            current = current.next;
        }
        if (flag) {
            head = head.next;
        }

        return head;
    }

    protected Node deleteDups(Node head) {
        Node current = head;
        Node previous = null;
        HashSet<Integer> set = new HashSet<>();

        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    // 2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
    protected int getLastNodeIndex(Node head) {
        Node current = head;
//        Node previous = null;
        int index = 0;
        while (current != null) {
//            previous = current;
            current = current.next;
            index += 1;
        }
        return index;
    }

    protected int printKthToLast(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    // 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and
    // last node, not necessarily the exact middle) of a singly linked list, given only access to that node
    protected Node deleteMiddleNode(Node head) {
        Node current = head;
        Node slow = head;
        Node fast = head;
        Node previous = head;
        Node middle = new Node();

        while (fast != null) {
            middle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        while (current != null) {
            if (current.data == middle.data) {
                previous.next = slow;
            }
            previous = current;
            current = current.next;
        }

        return head;
    }

    // 2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
    // The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
    // Write a function that adds the two numbers and returns the sum as a linked list.
    protected Node sumLists(Node list1, Node list2) {
        Node current1 = list1;
        Node current2 = list2;
        Node total = new Node();

        boolean hasRemainder = false;
        int index = 0;
        while (current1 != null) {
            int result;
            int sum = current1.data + current2.data;
            if (hasRemainder) {
                sum += 1;
            }
            if (sum > 9) {
                result = sum - 10;
                hasRemainder = true;
            } else {
                result = sum;
                hasRemainder = false;
            }

            if (index == 0) {
                total.data = result;
            } else if (index > 0) {
                Node newNode = new Node();
                newNode.data = result;
                Objects.requireNonNullElse(total.next, total).next = newNode;
            }
            current1 = current1.next;
            current2 = current2.next;
            index++;
        }
        return total;
    }

    protected Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node();
        Node current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.data;
            int y = l2 == null ? 0 : l2.data;
            int sum = x + y + carry;
            carry = sum / 10;
            Node node = new Node();
            node.data = sum % 10;
            current.next = node;
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            Node node = new Node();
            node.data = carry;
            current.next = node;
        }
        return dummy.next;
    }

    // 2.6 Palindrome: Implement a function to check if a linked list is a palindrome
    protected boolean isPalindromeList(Node node) {
        Stack<Integer> stack = new Stack<>();
        Node current = node;

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = node;
        while (current != null) {
            if (current.data != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    // 2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
    // intersecting node. Note that the intersection is defined based on reference, not value.
    // That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of
    // the second linked list, then they are intersecting
    protected Node getIntersectingNode(Node l1, Node l2) {
        Map<Node, Node> map = new IdentityHashMap<>();
        Node current1 = l1;
        Node current2 = l2;

        while (current1 != null) {
            map.put(current1, current1);
            current1 = current1.next;
        }

        while (current2 != null) {
            Node node = map.get(current2);
            if (node != null) {
                return node;
            }
            current2 = current2.next;
        }

        return null;
    }

}