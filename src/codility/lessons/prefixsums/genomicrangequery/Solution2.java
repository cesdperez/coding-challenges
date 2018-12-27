package codility.lessons.prefixsums.genomicrangequery;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * This one gets 100% but uses more memory than Solution
 */
public class Solution2 {

    private int[][] prefixes;

    public int[] solution(String S, int[] P, int[] Q) {
        if (S.length() == 1) {
            return new int[]{valueOf(S.charAt(0))};
        }

        loadPrefixes(S);
        return computeResult(P, Q);
    }

    private void loadPrefixes(String S) {
        prefixes = new int[3][S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            prefixes[0][i + 1] = prefixes[0][i] + ('A' == (S.charAt(i)) ? 1 : 0);
            prefixes[1][i + 1] = prefixes[1][i] + ('C' == (S.charAt(i)) ? 1 : 0);
            prefixes[2][i + 1] = prefixes[2][i] + ('G' == (S.charAt(i)) ? 1 : 0);
        }
    }

    private int[] computeResult(int[] P, int[] Q) {
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;

            if (prefixes[0][end] - prefixes[0][start] > 0) {
                result[i] = valueOf('A');
            } else if (prefixes[1][end] - prefixes[1][start] > 0) {
                result[i] = valueOf('C');
            } else if (prefixes[2][end] - prefixes[2][start] > 0) {
                result[i] = valueOf('G');
            } else {
                result[i] = valueOf('T');
            }
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
}
