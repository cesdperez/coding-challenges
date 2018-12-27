package interview.transactionalstack.approach3;

public interface Command<E> {

    E execute();

    void rollback();
}
