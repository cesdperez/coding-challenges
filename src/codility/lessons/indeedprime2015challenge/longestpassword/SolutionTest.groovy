package codility.lessons.indeedprime2015challenge.longestpassword

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(String s, int result) {
        given:
        def solution = new Solution()

        expect:
        solution.solution(s) == result

        where:
        s                           || result
        "test 5 a0A pass007 ?xy1"   || 7
        "test 5 a0A pass00723 ?xy1" || 9
        "test 5 a0A ?xy1"           || 3
        ""                          || -1
        "invalid"                   || -1
        "++a0A"                     || -1
        "a0A1"                      || -1
    }
}
