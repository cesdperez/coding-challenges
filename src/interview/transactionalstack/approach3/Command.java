package interview.transactionalstack.approach3;

import java.util.Stack;

public interface Command<E> {

    E execute(Stack<E> elements);

    void rollback(Stack<E> elements);
}
