package stack.leetcode;

import java.util.Stack;

// 232. Implement Queue using Stacks
// Implement a first in first out (FIFO) queue using only two stacks.
// The implemented queue should support all the functions
// of a normal queue (push, peek, pop, and empty).
public class MyQueue {

    protected Stack<Integer> stack1;
    protected Stack<Integer> stack2;
    protected int top;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    protected void push(int val) {
        if (stack1.isEmpty()) {
            top = val;
        }
        stack1.push(val);
    }

    protected int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int last = stack2.pop();

        if (!stack2.isEmpty()) {
            top = stack2.peek();
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return last;
    }

    protected Integer peek() {
        if (stack1.isEmpty()) return null;
        return top;
    }

    protected boolean isEmpty() {
        return stack1.isEmpty();
    }

}
