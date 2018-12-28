package hackerrank.interview.sorting.bubblesort

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "it sorts an array with bubble sort counting the amount of swaps"(int[] a, int[] expectedArray, int expectedSwaps) {
        given:
        def swaps = Solution.sortAndCountSwaps(a)

        expect:
        a == expectedArray
        swaps == expectedSwaps

        where:
        a               || expectedArray   || expectedSwaps
        null            || null            || 0
        []              || []              || 0
        [1]             || [1]             || 0
        [2, 1]          || [1, 2]          || 1
        [2, 1, 3, 4]    || [1, 2, 3, 4]    || 1
        [2, 1, -10, 50] || [-10, 1, 2, 50] || 3
    }
}
