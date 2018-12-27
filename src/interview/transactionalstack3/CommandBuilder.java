package interview.transactionalstack3;

import java.util.function.Supplier;

public class CommandBuilder<E> {

    private Supplier<E> onExecute;
    private Supplier<E> onRollback;

    public static CommandBuilder aCommand() {
        return new CommandBuilder<>();
    }

    public CommandBuilder<E> onExecute(Supplier<E> onExecute) {
        this.onExecute = onExecute;
        return this;
    }

    public CommandBuilder<E> onRollback(Supplier<E> onRollback) {
        this.onRollback = onRollback;
        return this;
    }

    public Command<E> build() {
        return new LambdaCommand<>(onExecute, onRollback);
    }
}
