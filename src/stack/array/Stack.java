package stack.array;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {

    protected Integer[] items;
    protected int capacity;
    protected int size;

    public Stack(int capacity) {
        this.items = new Integer[capacity];
        this.capacity = capacity;
    }

    protected void push(int item) {
        if (size < capacity) {
            items[size] = item;
            size++;
        }
    }

    protected Integer pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        size--;
        if (items[size] == null) throw new EmptyStackException();
        Integer last = items[size];
        items[size] = null;
       return last;
    }

    protected Integer peek() {
        int lastPosition = size - 1;
        if (items[lastPosition] == null) throw new EmptyStackException();
        return items[lastPosition];
    }

    protected boolean isEmpty() {
        return size == 0;
    }

}
