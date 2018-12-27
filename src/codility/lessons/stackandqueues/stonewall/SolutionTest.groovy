package codility.lessons.stackandqueues.stonewall

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(int[] h, int result) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(h) == result

        where:
        h                              || result
        [8, 8, 5, 7, 9, 8, 7, 4, 8]    || 7
        [1]                            || 1
        [1, 1, 1, 1]                   || 1
        [1, 1, 1, 1, 3, 3]             || 2
        [1, 1, 1, 1, 3, 3, 2, 1]       || 3
        [1, 2, 1, 2, 1, 2, 1, 2]       || 5
        [1, 2, 1, 2, 2, 2, 1, 2]       || 4
        [1, 2, 1, 2, 2, 2, 1, 2]       || 4
        [1, 2, 1, 3, 5, 7, 5, 3, 2, 1] || 6
        [1, 2, 2, 3, 5, 7, 5, 3, 2, 1] || 5
    }
}
