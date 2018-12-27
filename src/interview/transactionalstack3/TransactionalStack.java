package interview.transactionalstack3;

import java.util.Stack;

public class TransactionalStack<E> {

    private final Stack<E> elements;
    private final TransactionManager<E> transactionManager;

    public TransactionalStack() {
        elements = new Stack<>();
        transactionManager = new TransactionManager<>();
    }

    public E push(E element) {
        Command<E> c = CommandBuilder.aCommand()
                .onExecute(() -> elements.push(element))
                .onRollback(() -> elements.pop())
                .build();

        return transactionManager.execute(c);
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
