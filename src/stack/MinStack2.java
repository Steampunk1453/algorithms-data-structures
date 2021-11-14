package stack;

import java.util.Stack;

public class MinStack2 {

    Stack<Integer> stack;
    Stack<Integer> minimum;
    
    public MinStack2() {
        stack = new Stack<>(); //This will be the normal stack
        minimum = new Stack<>(); //This will be the minimum stack
        minimum.push(Integer.MAX_VALUE); //Maximum value to be pushed since it is initially empty (For comparison)
    }

    public void push(int val) {
        stack.push(val);
        if(minimum.isEmpty())
            minimum.push(val);
        else{
            if(minimum.peek() >= val) minimum.push(val);
        }

    }

    public void pop() {
        int temp = stack.peek();
        if(temp == minimum.peek()) minimum.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(minimum.isEmpty()) return 0;
        return minimum.peek();
    }

}
