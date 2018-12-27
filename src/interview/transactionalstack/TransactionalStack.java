package interview.transactionalstack;

import java.util.Stack;

public class TransactionalStack<E> {

    private final Stack<E> elements;
    private final TransactionManager<E> transactionManager;

    public TransactionalStack() {
        elements = new Stack<>();
        transactionManager = new TransactionManager<>();
    }

    public void push(E element) {
        transactionManager.execute(() -> elements.push(element));
    }

    public E pop() {
        transactionManager.execute(elements::pop);
        return null;
    }

    public void beginTransaction() {
        transactionManager.begin();
    }

    public void rollbackTransaction() {
        transactionManager.rollback();
    }

    public void commitTransaction() {
        transactionManager.commit();
    }
}
