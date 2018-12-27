package hackerrank.interview.arrays.newyearcaos

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solution"(int[] q, int r) {
        expect:
        Solution.minimumBribesWrapper(q) == r

        where:
        q                        || r
        [2, 1, 5, 3, 4]          || 3
        [2, 5, 1, 3, 4]          || -1
        [5, 1, 2, 3, 7, 8, 6, 4] || -1
        [1, 2, 5, 3, 7, 8, 6, 4] || 7
    }
}
