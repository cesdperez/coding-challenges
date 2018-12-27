package interview.transactionalstack.approach2;

import java.util.Stack;

public class Transaction<E> {

    private final Stack<Command<E>> commands;

    public Transaction() {
        this.commands = new Stack<>();
    }

    public E execute(Command<E> command) {
        commands.add(command);
        return command.execute();
    }

    public void commit() {
        commands.clear();
    }

    public void rollback() {
        commands.forEach(Command::rollback);
    }
}
