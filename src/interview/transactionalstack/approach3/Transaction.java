package interview.transactionalstack.approach3;

import java.util.Stack;

public class Transaction<E> {

    private final Stack<Command<E>> unexecuted;
    private final Stack<Command<E>> executed;

    public Transaction() {
        this.unexecuted = new Stack<>();
        this.executed = new Stack<>();
    }

    public void push(Command<E> command) {
        unexecuted.push(command);
    }

    public boolean execute(Stack<E> elements) {
        try {
            while (!unexecuted.empty()) {
                Command<E> command = unexecuted.pop();
                command.execute(elements);
                executed.push(command);
            }
            return true;
        } catch (Exception e) {
            while (!executed.empty()) {
                Command<E> command = executed.pop();
                command.rollback(elements);
                unexecuted.push(command);
            }
            return false;
        }
    }
}
