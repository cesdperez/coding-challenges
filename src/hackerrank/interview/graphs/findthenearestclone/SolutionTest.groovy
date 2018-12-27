package hackerrank.interview.graphs.findthenearestclone

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates the solution"(int nodes, int[] from, int[] to, long[] colors, int val, int result) {
        expect:
        Solution.findShortest(nodes, from, to, colors, val) == result

        where:
        nodes | from         | to           | colors          | val || result
        4     | [1, 1, 4]    | [2, 3, 2]    | [1, 2, 1, 1]    | 1   || 1
        4     | [1, 1, 4]    | [2, 3, 2]    | [1, 2, 3, 4]    | 2   || -1
        5     | [1, 1, 2, 3] | [2, 3, 4, 5] | [1, 2, 3, 3, 2] | 2   || 3
        7     | [1, 1, 2, 3] | [2, 3, 4, 5] | [1, 2, 3, 3, 2] | 2   || 3
    }
}
