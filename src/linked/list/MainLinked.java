package linked.list;

public class MainLinked {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2);
        node.appendToTail(3);
        node.toString();
    }

    static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;

            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

}
