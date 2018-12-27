package codility.lessons.demo

import spock.lang.Specification

class SolutionTest extends Specification {

    def "it finds the solution"(int[] A, int expected) {
        given:
        def s = new Solution()

        expect:
        s.solution(A) == expected

        where:
        A                  || expected
        [1, 3, 2]          || 4
        [-11, 3, 2]        || 1
        [-1, 0, 3, 2]      || 1
        [-1, 0, 1, 3, 2]   || 4
        [-1, -2, -3, 2323] || 1
        [1, 3, 6, 4, 1, 2] || 5
    }
}
