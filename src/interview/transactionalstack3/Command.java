package interview.transactionalstack3;

public interface Command<E> {

    E execute();

    void rollback();
}
