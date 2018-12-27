package interview.transactionalstack.approach2;

import java.util.Stack;

public class PushCommand<E> implements Command<E> {

    private final E element;
    private final Stack<E> elements;

    public PushCommand(E element, Stack<E> elements) {
        this.element = element;
        this.elements = elements;
    }

    @Override
    public E execute() {
        return elements.push(element);
    }

    @Override
    public void rollback() {
        elements.pop();
    }
}
