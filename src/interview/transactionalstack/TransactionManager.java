package interview.transactionalstack;

import java.util.Stack;

public class TransactionManager<E> {

    private final Stack<Transaction<E>> transactions;

    public TransactionManager() {
        transactions = new Stack<>();
    }

    public void begin() {
        transactions.push(new Transaction<>());
    }

    public void rollback() {
        transactions.pop().rollback();
    }

    public void commit() {
        transactions.pop().commit();
    }

    public void execute(Command<E> command) {
        if (transactions.isEmpty()) {
            command.execute();
        } else {
            Transaction<E> currentTransaction = transactions.peek();
            currentTransaction.execute(command);
        }
    }
}
