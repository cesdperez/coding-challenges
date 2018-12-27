package interview.concurrentstack.blocking;

import java.util.ArrayDeque;

/**
 * Decorates an ArrayDeque making it thread safe.
 * It uses java synchronized mechanism and all operations are blocking.
 *
 * Pros:
 * - Readable and easy to write.
 * - Makes it explicit to API consumers that it's thread safe.
 *
 * Cons:
 * - It blocks the whole object for any operation (you could do more fine grained blocking).
 * - Blocking on "this" is considered an anti-pattern for many reasons (go google).
 */
public class BlockingConcurrentStack<T> {

    private ArrayDeque<T> deque;

    public BlockingConcurrentStack(int initialCapacity) {
        this.deque = new ArrayDeque<>(initialCapacity);
    }

    public BlockingConcurrentStack() {
        deque = new ArrayDeque<>();
    }

    public synchronized T pop() {
        return this.deque.pop();
    }

    public synchronized void push(T element) {
        this.deque.push(element);
    }

    public synchronized T peek() {
        return this.deque.peek();
    }

    public synchronized int size() {
        return this.deque.size();
    }
}
