package interview.transactionalstack.approach3;

import java.util.Stack;

public class TransactionalStack<E> {

    private final Stack<E> elements;

    public TransactionalStack() {
        this.elements = new Stack<>();
    }

    public TransactionalStack(Stack<E> elements) {
        this.elements = elements;
    }

    public synchronized E push(E element) {
        return elements.push(element);
    }

    public synchronized E pop() {
        return elements.pop();
    }

    public synchronized boolean executeTransaction(Transaction<E> transaction) {
        return transaction.execute(elements);
    }
}
