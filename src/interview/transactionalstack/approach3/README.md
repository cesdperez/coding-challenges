In this approach Transactions are executed by themselves, which is better for isolation.

This solution is thread-safe blocking: if you start executing a transaction, all the stack instance locks and you can't execute anything else until the transaction is finished (successfully or not).

Also a new improvement for atomicity: transaction executing is surrounded in a try-catch block, if anything fails it rollbacks to the initial state (so it's more likely to be atomic now).
