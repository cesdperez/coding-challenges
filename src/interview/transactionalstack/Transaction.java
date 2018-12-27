package interview.transactionalstack;

import java.util.Collection;
import java.util.LinkedList;

public class Transaction<E> {

    private final Collection<Command<E>> commands;

    public Transaction() {
        this.commands = new LinkedList<>();
    }

    public void execute(Command<E> command) {
        commands.add(command);
    }

    public void commit() {
        commands.forEach(Command::execute);
    }

    public void rollback() {
        commands.clear();
    }
}
