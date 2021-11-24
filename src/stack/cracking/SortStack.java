package stack.cracking;

import java.util.Stack;

// 3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use an additional
// temporary stack, but you may not copy the elements into any other data structure (such as an array).
// The stack supports the following operations: push, pop, peek, and isEmpty.
public class SortStack {

    protected Stack<Integer> stack;
    protected Stack<Integer> minStack;
    protected int min;

    public SortStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    protected void pushQueueOrder(int item) {
        // 1-2-3-4
        // First item
        if (stack.isEmpty()) {
            min = item;
            stack.push(item);
            // Rest of items
        } else {
            int current = stack.peek();
            if (item > current) {
                // Add new item below of current
                stack.push(item);
            } else if (item < current) {
                if (item < min) {
                    // Reorder the whole stack to put the item first
                    min = item;
                    while (!stack.isEmpty()) {
                        minStack.push(stack.pop());
                    }
                    stack.push(min);
                    while (!minStack.isEmpty()) {
                        stack.push(minStack.pop());
                    }
                } else {
                    // Add new item above of current
                    int last = stack.pop();
                    stack.push(item);
                    stack.push(last);
                }
            }
        }
    }

    public void pushStackOrder(Integer element) {
        // 4-3-2-1
        if (stack.isEmpty() || element <= stack.peek()) {
            stack.push(element);
        } else {
            Stack<Integer> newStack = new Stack<>();
            while (!stack.isEmpty() && element > stack.peek()) {
                newStack.push(stack.pop());
            }
            stack.push(element);
            while (!newStack.empty()) {
                stack.push(newStack.pop());
            }
        }
    }

    protected int pop() {
        return stack.pop();
    }

    protected int peek() {
        return stack.peek();
    }

    protected boolean isEmpty() {
        return stack.isEmpty();
    }

}
