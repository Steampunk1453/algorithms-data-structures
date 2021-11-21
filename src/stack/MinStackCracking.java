package stack;

import java.util.Stack;

// 3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns
// the minimum element? Push, pop and min should all operate in 0(1) time
public class MinStackCracking {

    protected Stack<Integer> stack;
    protected Stack<Integer> minimumElements;
    protected int minValue;

    public MinStackCracking() {
        this.stack = new Stack<>();
        this.minimumElements = new Stack<>();
    }

    protected void push(int val) {
        if (stack.isEmpty()) {
            minValue = val;
            minimumElements.push(val);
        } else {
            if (minValue > val) {
                minimumElements.push(val);
                minValue = val;
            }
        }
        stack.push(val);
    }

    protected Integer pop() {
        if (stack.peek() == minValue) {
            minimumElements.pop();
            minValue = minimumElements.peek();
        }
        return stack.pop();
    }

    protected int min() {
        if (minimumElements.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minValue;
    }

}
