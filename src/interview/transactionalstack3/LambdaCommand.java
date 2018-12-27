package interview.transactionalstack3;

import java.util.function.Supplier;

public class LambdaCommand<E> implements Command<E> {

    private final Supplier<E> onExecute;
    private final Supplier<E> onRollback;

    public LambdaCommand(Supplier<E> onExecute, Supplier<E> onRollback) {
        this.onExecute = onExecute;
        this.onRollback = onRollback;
    }

    @Override
    public E execute() {
        return onExecute.get();
    }

    @Override
    public void rollback() {
        onRollback.get();
    }
}
