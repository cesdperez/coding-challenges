Approach using transaction with eager execution.

Pros:
- You don't need deferred results, you can know the operation result immediately.

Cons:
- It doesn't keep with atomicity.
- Requires more code.
- Required to implement rollback.
- Requires one class per command.
- Same isolation problem than approach 1.
