package codility.lessons.maximumsliceproblem.example

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution inefficiently"(int[] a, int result) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(a) == result

        where:
        a                        || result
        []                       || 0
        [-1]                     || 0
        [-1, -2, -3]             || 0
        [1]                      || 1
        [1, 2, 3]                || 6
        [1, 2, -1]               || 3
        [5, -7, 4, 5, -3, 4, -1] || 10
        [5, -6, 4, 5, -3, 3, -1] || 9
        [1, -2, -3, -5]          || 1
    }

    @Unroll
    def "it calculates solution efficiently"(int[] a) {
        given:
        def solution1 = new Solution()
        def solution2 = new SolutionPrefixSum()
        def solution3 = new SolutionSlices()

        expect:
        solution2.solution(a) == solution1.solution(a)
        solution3.solution(a) == solution1.solution(a)

        where:
        a                        | _
        []                       | _
        [-1]                     | _
        [-1, -2, -3]             | _
        [1]                      | _
        [1, 2, 3]                | _
        [1, 2, -1]               | _
        [5, -7, 4, 5, -3, 4, -1] | _
        [5, -6, 4, 5, -3, 3, -1] | _
        [1, -2, 1, -1, 2]        | _
        [1, 2, 3, -99, 100]      | _
        [1, -2, 2]               | _
        [1, -2, 1]               | _
        [1, -2, -3, -5]          | _
        [1, -2, -3, -5, 1]       | _
        [1, -2]                  | _
        [1, 2, 3, -99]           | _
        [1, -2, 2, -3, 3, -4, 3] | _
    }
}
