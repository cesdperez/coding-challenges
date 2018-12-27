package codility.lessons.prefixsums.countdiv;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 */
public class Solution {

    public int solution(int A, int B, int K) {
        int restA = A % K;
        int restB = B % K;

        int result = (B - A) / K;

        if (restA == 0 || restB < restA) result++;

        return result;
    }
}
