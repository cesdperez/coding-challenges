package codility.lessons.prefixsums.example;

public class Solution {

    public int[] solution(int[] A) {
        return prefixSum(A);
    }

    private int[] prefixSum(int[] A) {
        int[] p = new int[A.length];
        p[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            p[i] = p[i - 1] + A[i];
        }
        return p;
    }
}
