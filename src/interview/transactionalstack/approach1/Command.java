package interview.transactionalstack.approach1;

public interface Command<E> {

    E execute();
}
