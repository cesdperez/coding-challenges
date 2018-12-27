package interview.transactionalstack.approach2;

import java.util.Stack;

public class PopCommand<E> implements Command<E> {

    private E element;
    private final Stack<E> elements;

    public PopCommand(Stack<E> elements) {
        this.elements = elements;
    }

    @Override
    public E execute() {
        element = elements.pop();
        return element;
    }

    @Override
    public void rollback() {
        elements.push(element);
    }
}
