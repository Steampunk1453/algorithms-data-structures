package queue.linked.list;

import java.util.NoSuchElementException;

public class Queue<T> {

    protected QueueNode<T> first;
    protected QueueNode<T> last;
    protected int size;

    static class QueueNode<T> {
        protected T data;
        protected QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    protected void enqueue(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if (last == null) {
            first = last = node;
        }
        last.next = node;
        last = node;
        size++;
    }

    protected void enqueue2(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if (size == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    protected T dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return data;
    }

    protected T peek() {
        if (first != null) {
           return first.data;
        }
        return  null;
    }

    protected boolean isEmpty() {
        return first == null;
    }

}
