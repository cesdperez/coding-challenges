package codility.lessons.prefixsums.countdiv


import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solutions inefficiently"(int a, int b, int k, int result) {
        given:
        def solution = new SolutionInefficient()

        expect:
        solution.solution(a, b, k) == result

        where:
        a   | b         | k         || result
        6   | 11        | 2         || 3
        1   | 11        | 7         || 1
        101 | 100000000 | 100000000 || 1
        10  | 10        | 2         || 1
    }

    @Unroll
    def "it calculates accurate efficient solutions"(int a, int b, int k) {
        given:
        def expected = new SolutionInefficient()
        def result = new Solution()

        expect:
        result.solution(a, b, k) == expected.solution(a, b, k)

        where:
        a   | b          | k
        6   | 11         | 2
        6   | 11         | 7
        6   | 11         | 2
        1   | 11         | 7
        10  | 10         | 2
        0   | 0          | 2
        1   | 1          | 2
        0   | 14         | 2
        1   | 14         | 2
        2   | 2          | 2
        11  | 345        | 17
        101 | 100000000  | 100000000
        101 | 2000000000 | 2
    }
}
