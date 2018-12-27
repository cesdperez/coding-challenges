package interview.transactionalstack2;

public interface Command<E> {

    E execute();

    void rollback();
}
