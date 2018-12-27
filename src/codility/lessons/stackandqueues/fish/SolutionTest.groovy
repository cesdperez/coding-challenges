package codility.lessons.stackandqueues.fish

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(int[] a, int[] b, int result) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(a, b) == result

        where:
        a                  | b                  || result
        [4, 3, 2, 1, 5]    | [0, 1, 0, 0, 0]    || 2
        [4, 3, 2, 8, 1, 5] | [0, 1, 0, 1, 0, 1] || 4
        [8, 10, 12, 14]    | [1, 1, 1, 0]       || 1
        [8, 10, 12, 14]    | [0, 0, 0, 0]       || 4
        [8, 10, 12, 14]    | [1, 1, 0, 0]       || 2
        [8]                | [0]                || 1
        [8]                | [1]                || 1
        [0, 1, 2]          | [1, 1, 1]          || 3
    }
}
