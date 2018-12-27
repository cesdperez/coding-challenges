package codility.lessons.maximumsliceproblem.example;

import static java.lang.Math.max;

/**
 * https://codility.com/media/train/7-MaxSlice.pdf
 */
public class Solution {

    public int solution(int[] A) {
        int result = 0;
        int N = A.length;

        for (int i = 0; i < N; i++) {
            int partial = 0;
            for (int j = i; j < N; j++) {
                partial += A[j];
                result = max(result, partial);
            }
        }
        return result;
    }
}
