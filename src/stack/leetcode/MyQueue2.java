package stack.leetcode;

import java.util.Stack;

// 232. Implement Queue using Stacks
// Implement a first in first out (FIFO) queue using only two stacks.
// The implemented queue should support all the functions
// of a normal queue (push, peek, pop, and empty).
public class MyQueue2 {

    protected Stack<Integer> stack1;
    protected Stack<Integer> stack2;
    protected int top;

    public MyQueue2() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    protected void push(int val) {
        if (stack1.empty()) {
            top = val;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(val);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    protected int pop() {
        int last = stack1.pop();
        if (!stack1.empty()) {
            top = stack1.peek();
        }
        return last;
    }

    protected Integer peek() {
        if (stack1.isEmpty()) {
            return null;
        }
        return top;
    }

    protected boolean isEmpty() {
        return stack1.isEmpty();
    }

}
