package codility.lessons.prefixsums.genomicrangequery


import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solutions"(String s, int[] p, int[] q, int[] result) {
        given:
        def solution1 = new Solution1()
        def solution2 = new Solution2()
        def solution3 = new SolutionBad()

        expect:
        solution1.solution(s, p, q) == result
        solution2.solution(s, p, q) == result
        solution3.solution(s, p, q) == result

        where:
        s                  | p         | q          || result
        "CAGCCTA"          | [2, 5, 0] | [4, 5, 6]  || [2, 4, 1]
        "CAGCCTA"          | [0, 0, 0] | [4, 2, 6]  || [1, 1, 1]
        "CGCCTCCCCTTTTGTT" | [0, 0, 0] | [4, 2, 10] || [2, 2, 2]
        "C"                | [0]       | [0]        || [2]
        "G"                | [0]       | [1]        || [3]
        "GA"               | [0]       | [1]        || [1]
    }
}
