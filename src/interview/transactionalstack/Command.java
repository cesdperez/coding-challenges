package interview.transactionalstack;

public interface Command<E> {

    E execute();
}
