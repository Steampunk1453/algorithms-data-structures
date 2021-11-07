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

    protected void add(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if (last == null) {
            first = last = node;
        }
        last.next = node;
        last = node;
        size++;
    }

    protected T remove() {
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
