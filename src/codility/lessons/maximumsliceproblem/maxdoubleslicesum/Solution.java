package codility.lessons.maximumsliceproblem.maxdoubleslicesum;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 */
public class Solution {

    public int solution(int[] A) {
        if (A.length < 3) throw new UnsupportedOperationException();

        int maxSlice = 0;
        int maxDoubleSlice = 0;
        int minValue = A[1];
        for (int i = 1; i < A.length - 1; i++) {
            if (maxSlice + A[i] < 0) {
                maxSlice = 0;
                minValue = 0;
            } else {
                maxSlice = maxSlice + A[i];
                minValue = min(minValue, A[i]);
            }

            maxDoubleSlice = max(maxDoubleSlice, maxSlice - minValue);
        }
        return maxDoubleSlice;
    }
}
