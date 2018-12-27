package codility.lessons.prefixsums.countdiv;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 */
public class SolutionInefficient {

    public int solution(int A, int B, int K) {
        if (B < A) throw new UnsupportedOperationException();

        int result = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) result++;
        }
        return result;
    }
}
