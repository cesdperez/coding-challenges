Approach using transaction with lazy execution.

Pros:
- Maybe the simplest and with less code required.
- You don't need to rollback commands, because they don't execute until "commit".

Cons:
- Since you don't execute commands until "commit", you can't know the execution result immediately (eg for pop() operation).
    - A workaround for that could be returning deferred values (eg Futures or Promises).
  