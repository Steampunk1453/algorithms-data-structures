package queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// 225. Implement Stack using Queues
// Implement a last-in-first-out (LIFO) stack using only two queues.
// The implemented stack should support the functions of a normal stack (push, top, pop, and empty).
public class MyStack {

    protected final Queue<Integer> queue = new LinkedList<>();

    // Push element val onto stack.
    public void push(int val) {
        queue.add(val);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    // Removes the element on top of the stack.
    public int pop() {
       return queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
