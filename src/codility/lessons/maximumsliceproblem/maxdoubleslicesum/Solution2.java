package codility.lessons.maximumsliceproblem.maxdoubleslicesum;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 */
public class Solution2 {

    public int solution(int[] A) {
        if (A.length < 3) throw new UnsupportedOperationException();

        int maxDoubleSlice = 0;

        int[] prefixSum = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1] + A[i], 0);
        }

        int[] suffixSum = new int[A.length];
        for (int i = A.length - 2; i > 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1] + A[i], 0);
        }

        for (int i = 1; i < A.length - 1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, prefixSum[i - 1] + suffixSum[i + 1]);
        }

        return maxDoubleSlice;
    }

}
