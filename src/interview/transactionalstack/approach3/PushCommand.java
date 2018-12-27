package interview.transactionalstack.approach3;

import java.util.Stack;

public class PushCommand<E> implements Command<E> {

    private final E element;

    public PushCommand(E element) {
        this.element = element;
    }

    @Override
    public E execute(Stack<E> elements) {
        return elements.push(element);
    }

    @Override
    public void rollback(Stack<E> elements) {
        elements.pop();
    }
}
