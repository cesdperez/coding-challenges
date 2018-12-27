package interview.transactionalstack2

import spock.lang.Specification
import spock.lang.Unroll

class TransactionalStackIT extends Specification {

    @Unroll
    def "it performs basic Stack operations"(steps, expected) {
        given:
        def stack = new TransactionalStack()

        and:
        def result = steps.collect { it.call(stack) }

        expect:
        result == expected

        where:
        steps                                          || expected
        [{ it.push(1) }]                               || [1]
        [{ it.push(1) }, { it.push(2) }, { it.pop() }] || [1, 2, 2]
    }

    @Unroll
    def "it handles errors"(steps, error) {
        when:
        def stack = new TransactionalStack()

        and:
        steps.collect { it.call(stack) }

        then:
        thrown(error)

        where:
        steps                                        || error
        [{ it.pop() }]                               || EmptyStackException
        [{ it.push(1) }, { it.pop() }, { it.pop() }] || EmptyStackException
    }

    @Unroll
    def "it performs transactional operations"(steps, expected) {
        given:
        def stack = new TransactionalStack()

        and:
        def result = steps.collect { it.call(stack) }

        expect:
        result == expected

        where:

        steps                        || expected

        [{ it.push(1) },
         { it.beginTransaction() },
         { it.push(2) },
         { it.push(3) },
         { it.pop() },
         { it.commitTransaction() },
         { it.pop() }]               || [1, null, 2, 3, 3, null, 2]

        [{ it.push(1) },
         { it.beginTransaction() },
         { it.push(2) },
         { it.push(3) },
         { it.pop() },
         { it.rollbackTransaction() },
         { it.pop() }]               || [1, null, 2, 3, 3, null, 1]
    }
}
