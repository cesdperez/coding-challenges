package codility.lessons.maximumsliceproblem.example;

import static java.lang.Math.min;

/**
 * https://codility.com/media/train/7-MaxSlice.pdf
 */
public class SolutionPrefixSum {

    public int solution(int[] A) {
        int[] prefixSum = prefixSum(A);

        int max = 0;
        int index = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] >= max) {
                max = prefixSum[i];
                index = i;
            }
        }

        int min = 0;
        for (int i = 0; i <= index; i++) {
            min = min(min, prefixSum[i]);
        }

        return max - min;
    }

    private int[] prefixSum(int[] A) {
        int[] p = new int[A.length + 1];
        p[0] = 0;
        for (int i = 1; i < A.length + 1; i++) {
            p[i] = p[i - 1] + A[i - 1];
        }
        return p;
    }
}
