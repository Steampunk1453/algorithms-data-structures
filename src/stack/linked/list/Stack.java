package stack.linked.list;

import java.util.EmptyStackException;

public class Stack<T> {

    protected StackNode<T> top;
    protected int size;

    static class StackNode<T> {
        protected T data;
        protected StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }


    protected void push(T item) {
        StackNode<T> node = new StackNode<>(item);
        node.next = top;
        top = node;
        size++;
    }

    protected T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
       return item;
    }

    protected T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    protected boolean isEmpty() {
        return top == null;
    }

}
