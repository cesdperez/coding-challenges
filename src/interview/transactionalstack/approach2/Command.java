package interview.transactionalstack.approach2;

public interface Command<E> {

    E execute();

    void rollback();
}
