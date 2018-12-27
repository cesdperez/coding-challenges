package interview.transactionalstack.approach2;

import java.util.Stack;

public class TransactionalStack<E> {

    private final Stack<E> elements;
    private final TransactionManager<E> transactionManager;

    public TransactionalStack() {
        elements = new Stack<>();
        transactionManager = new TransactionManager<>();
    }

    public E push(E element) {
        PushCommand<E> command = new PushCommand<>(element, elements);
        return transactionManager.execute(command);
    }

    public E pop() {
        PopCommand<E> command = new PopCommand<>(elements);
        return transactionManager.execute(command);
    }

    //TODO rest of operations

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
