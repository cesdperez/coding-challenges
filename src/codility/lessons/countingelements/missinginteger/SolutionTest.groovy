package codility.lessons.countingelements.missinginteger


import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solutions"(int[] a, int s) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(a) == s

        where:
        a                       || s
        [-100000000, 100000000] || 1
        [1, 3, 6, 4, 1, 2]      || 5
        [1, 3, 6, 3, 1, 2]      || 4
    }
}
