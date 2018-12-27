package codility.lessons.countingelements.maxcounters

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solutions"(int n, int[] a, int[] s) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(n, a) == s

        where:
        n | a                                 || s
        5 | [3, 4, 4, 2, 1, 4, 4]             || [1, 1, 1, 4, 0]
        5 | [3, 4, 4, 6, 1, 4, 4]             || [3, 2, 2, 4, 2]
        5 | [3, 4, 4, 6, 6, 6, 6, 1, 4, 4]    || [3, 2, 2, 4, 2]
        5 | [3, 4, 4, 6, 6, 2, 1, 6, 4, 4]    || [3, 3, 3, 5, 3]
        5 | [3, 4, 4, 6, 2, 2, 1, 6, 4, 4, 7] || [4, 4, 4, 6, 4]
        1 | [0]                               || [0]
        1 | [1]                               || [1]
        1 | [1, 2]                            || [1]
        2 | []                                || [0, 0]
    }
}
