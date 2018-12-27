package codility.lessons.fibonaccinumbers.fibfrog

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(int[] a, int result) {
        given:
        def solution = new Solution()
        def solution2 = new SolutionInefficient()

        expect:
//        solution.solution(a) == result
        solution2.solution(a) == result

        where:
        a                                       || result
        [1, 1, 0, 0, 0]                         || 2
        [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0]       || 3
        [1, 0, 0, 0, 0]                         || 2
        []                                      || 1
        [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0]    || 1
        [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1] || 2
        [0, 0, 0, 0, 1]                         || 2
        [0, 0, 0, 1]                            || 1
        [0, 0, 1, 0]                            || 1
        [0, 0, 0]                               || -1
    }
}
