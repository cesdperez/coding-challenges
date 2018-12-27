package codility.lessons.maximumsliceproblem.example;

import static java.lang.Math.max;

/**
 * https://codility.com/media/train/7-MaxSlice.pdf
 */
public class SolutionSlices {

    public int solution(int[] A) {
        int maxEnding = 0;
        int maxSlice = 0;
        for (int a : A) {
            maxEnding = max(0, maxEnding + a);
            maxSlice = max(maxSlice, maxEnding);
        }
        return maxSlice;
    }
}
