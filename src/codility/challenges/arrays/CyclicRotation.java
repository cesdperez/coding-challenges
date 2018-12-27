package cesdperez.codingchallenges.codility.arrays;

class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if (A.length < 2) return A;

        for (int i = 0; i < K; i++) {
            A = shift(A);
        }
        return A;
    }

    private int[] shift(int[] a) {
        int[] b = new int[a.length];

        b[0] = a[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
            b[i + 1] = a[i];
        }

        return b;
    }
}