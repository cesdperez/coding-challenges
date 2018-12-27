package hackerrank.interview.arrays.arrayds

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it calculates solutions"(int[][] arr, int r) {
        expect:
        Solution.hourglassSum(arr) == r

        where:
        arr                  || r
        [[1, 1, 1, 0, 0, 0],
         [0, 1, 0, 0, 0, 0],
         [1, 1, 1, 0, 0, 0],
         [0, 0, 2, 4, 4, 0],
         [0, 0, 0, 2, 0, 0],
         [0, 0, 1, 2, 4, 0]] || 19
        [[-9, -9, -9, 1, 1, 1],
         [0, -9, 0, 4, 3, 2],
         [-9, -9, -9, 1, 2, 3],
         [0, 0, 8, 6, 6, 0],
         [0, 0, 0, -2, 0, 0],
         [0, 0, 1, 2, 4, 0]] || 28

    }
}
