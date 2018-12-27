package codility.lessons.demo;

import java.util.Arrays;

class Solution {

    public int solution(int[] A) {
        Arrays.sort(A);
        int solution = 1;
        for (int i : A) {
            if (i <= 0) continue;

            if (i == solution) {
                solution++;
                continue;
            }

            if (i > solution) {
                break;
            }
        }

        return solution;
    }
}
