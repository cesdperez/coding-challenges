package codility.lessons.fibonaccinumbers.fibfrog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;


/**
 * Incomplete
 */
public class SolutionInefficient {


    public int solution(int[] A) {
        return jumps(A);
    }

    private int jumps(int[] A) {
        List<Integer> fibonacci = fibonacci(A);

        if (fibonacci.isEmpty()) return -1;

        if (fibonacci.get(fibonacci.size() - 1) == A.length + 1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int f : fibonacci) {
            min = min(min, 1 + jumps(Arrays.copyOfRange(A, f, A.length)));
        }

        return min;
    }

    private List<Integer> fibonacci(int[] A) {
        int N = A.length;
        List<Integer> fib = new ArrayList<>();
        int first = 0;
        int second = 1;
        int f = 1;
        while (f < N) {
            f = first + second;
            first = second;
            second = f;
            if (f == N + 1)
                fib.add(f);
            else if (f <= N && A[f - 1] == 1)
                fib.add(f);
        }
        return fib;
    }
}
