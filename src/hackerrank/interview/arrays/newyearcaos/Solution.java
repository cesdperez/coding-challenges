package hackerrank.interview.arrays.newyearcaos;

public class Solution {

    static void minimumBribes(int[] q) {
        int solution = minimumBribesWrapper(q);
        if (solution == -1) {
            System.out.println("Too chaotic");
            return;
        }
        System.out.println(solution);
    }

    static int minimumBribesWrapper(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2)
                return -1;
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) bribes++;
            }
        }
        return bribes;
    }
}
