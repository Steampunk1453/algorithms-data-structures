package stack.example;

// Driver code
class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.peek() + " Peeked from stack");
    }
}

class Stack {
    static final int MAX = 1000;
    int top;
    int[] a = new int[MAX]; // Maximum size of stack.example.Stack

    boolean isEmpty() {
        return (top < 0);
    }

    Stack() {
        top = -1;
    }

    void push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("stack.example.Stack Overflow");
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("stack.example.Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("stack.example.Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }
}

