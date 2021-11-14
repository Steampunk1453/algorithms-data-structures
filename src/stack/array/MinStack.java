package stack.array;

import java.util.*;

// 155. Min Stack
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time
// O(1)
public class MinStack {
    protected Integer[] items;
    protected int capacity;
    protected int size;
    protected TreeSet<Integer> min;

    public MinStack(int capacity) {
        this.items = new Integer[capacity];
        this.min = new TreeSet<>();
        this.capacity = capacity;
    }

    public void push(int val) {
        if (size < capacity) {
            items[size] = val;
            size++;
            min.add(val);
        }
    }

    public void pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        size--;
        if (items[size] == null) throw new EmptyStackException();
        int last = items[size];
        min.remove(last);
        items[size] = null;
    }

    public int top() {
        int lastPosition = size - 1;
        if (items[lastPosition] == null) throw new EmptyStackException();
        return items[lastPosition];
    }

    public Integer getMin() {
        return min.first();
//        return min.stream().reduce((prev, next) -> next).orElse(null);
//        Object[] result = min.toArray();
//        return (int) result[result.length - 1];
    }

}
