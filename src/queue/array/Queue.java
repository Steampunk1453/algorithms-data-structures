package queue.array;

import java.util.NoSuchElementException;

public class Queue {

    protected Integer[] items;
    protected int capacity;
    protected int first;
    protected int size;

    public Queue(int capacity) {
        this.items = new Integer[capacity];
        this.capacity = capacity;
    }

    protected void enqueue(int data) {
        if (size < capacity) {
            items[size] = data;
            size++;
        }
    }

    protected Integer dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Integer removedItem = items[first];
        for (int i = 0; i < size -1; i++) {
            items[i] = items[i + 1];
        }
       // if (size - 1 >= 0) System.arraycopy(items, 1, items, 0, size - 1);
        size--;
        items[size] = null;
        return removedItem;
    }

    protected Integer peek() {
        return items[first];
    }

    protected boolean isEmpty() {
        return items[first] == null;
    }

}
