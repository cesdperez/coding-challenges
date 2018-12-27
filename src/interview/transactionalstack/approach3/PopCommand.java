package interview.transactionalstack.approach3;

import java.util.Stack;

public class PopCommand<E> implements Command<E> {

    private E element;

    @Override
    public E execute(Stack<E> elements) {
        element = elements.pop();
        return element;
    }

    @Override
    public void rollback(Stack<E> elements) {
        elements.push(element);
    }
}
