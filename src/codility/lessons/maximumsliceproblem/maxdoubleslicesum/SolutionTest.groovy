package codility.lessons.maximumsliceproblem.maxdoubleslicesum


import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(int[] a, int result) {
        given:
        def solution = new Solution()
        def solution2 = new Solution2()

        expect:
        solution.solution(a) == result
        solution2.solution(a) == result

        where:
        a                                      || result
        [3, 2, 6, -1, 4, 5, -1, 2]             || 17
        [3, 2, 6]                              || 0
        [3, 2, 6, 3, 4]                        || 9
        [3, -99, 6]                            || 0
        [3, -99, 6, 4]                         || 6
        [3, 100, 100, -100, -100, 100, 100, 4] || 300
    }
}
