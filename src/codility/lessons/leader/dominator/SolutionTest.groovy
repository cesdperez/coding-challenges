package codility.lessons.leader.dominator

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(int[] a, int result) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(a) == result

        where:
        a                            || result
        [3, 4, 3, 2, 3, -1, 3, 3]    || 7
        [3, 2, 4, 3, 2, 1, -1, 3, 3] || -1
        [3, 2, 4, 3, 2, 1, 3, 3, 3]  || 8
        [3]                          || 0
        []                           || -1
    }
}
