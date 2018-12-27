package interview.concurrentstack.nonblocking;

import java.util.EmptyStackException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Non-blocking concurrent stack using Treiber's algorithm
 * https://en.wikipedia.org/wiki/Treiber_Stack
 */
public class NonBlockingConcurrentStack<T> {

    private AtomicReference<Node<T>> head = new AtomicReference<>();

    public void push(T t) {
        if (t == null) {
            throw new IllegalArgumentException("You can't push null elements to the stack");
        }

        Node<T> futureHead = new Node<>(t);
        Node<T> currentHead;

        do {
            currentHead = head.get();
            futureHead.setPrevious(currentHead);
        } while (!head.compareAndSet(currentHead, futureHead));
    }

    public T pop() {
        Node<T> currentHead = null;
        Node<T> futureHead = null;
        do {
            currentHead = head.get();
            if (currentHead == null) {
                throw new EmptyStackException();
            }
            futureHead = currentHead.previous;
        } while (!head.compareAndSet(currentHead, futureHead));

        return currentHead.data;
    }

    public T peek() {
        Node<T> currentHead = head.get();
        if (currentHead == null)
            throw new EmptyStackException();

        return currentHead.data;
    }

    public boolean isEmpty() {
        return head.get() == null;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> previous;

        private Node(T data) {
            this.data = data;
        }

        private void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
