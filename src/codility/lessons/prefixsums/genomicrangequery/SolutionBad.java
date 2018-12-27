package codility.lessons.prefixsums.genomicrangequery;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * Just for test purposes
 */
public class SolutionBad {

    public int[] solution(String S, int[] P, int[] Q) {
        if (S.length() == 1) {
            return new int[]{valueOf(S.charAt(0))};
        }

        int M = P.length;
        int[] result = new int[M];

        for (int m = 0; m < M; m++) {
            result[m] = computeMin(S, P[m], Q[m]);
        }

        return result;
    }

    private int valueOf(char c) {
        if (c == 'A') return 1;
        if (c == 'C') return 2;
        if (c == 'G') return 3;
        if (c == 'T') return 4;
        return -1;
    }

    private int computeMin(String S, int start, int end) {
        int min = 4;
        for (int s = start; s <= end; s++) {
            char c = S.charAt(s);
            min = valueOf(c) < min ? valueOf(c) : min;
        }
        return min;
    }
}
