package cesdperez.codingchallenges.codility.timecomplexity;

import java.util.Arrays;

public class PermMissingElement {

    public int solution(int[] A) {

        int N = A.length;
        boolean[] B = new boolean[N + 2];

        for (int a : A) {
            B[a] = true;
        }

        for (int i = 1; i < B.length; i++) {
            if (!B[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        test(new int[]{}); // 1
        test(new int[]{1, 2, 4, 5, 6}); // 3
        test(new int[]{1, 2, 4}); // 3

        int L = 100001;
        int[] edge = new int[L];
        for (int i = 0; i < L; i++) {
            edge[i] = i;
        }
        test(edge); // 100001
    }

    private static void test(int[] A) {
        PermMissingElement solution = new PermMissingElement();
        int s = solution.solution(A);
        System.out.printf("solution for A=%s is: %s", Arrays.toString(A), s);
        System.out.println();
    }
}
