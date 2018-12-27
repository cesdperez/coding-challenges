package codility.lessons.fibonaccinumbers.fibfrog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * Incomplete
 */
public class Solution {

    private List<Integer> fib;

    public int solution(int[] A) {
        int N = A.length + 1;
        fib = fibonacci(N);

        return computeJumps(A);
    }

    private int computeJumps(int[] a) {
        int n = a.length;
        for (int f : fib) {
            if (f == n + 1) return 1;
            if ((f - 1) < a.length && a[f - 1] == 1) {
                if (n - f < 0) return -1;
                int rest = computeJumps(Arrays.copyOfRange(a, f, n));
                if (rest == -1) return -1;
                return 1 + rest;
            }
        }
        return -1;
    }

    private List<Integer> fibonacci(int N) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        int a = 0;
        int b = 1;
        int f = 1;
        while (f < N) {
            f = a + b;
            a = b;
            b = f;
            if (f <= N) fib.add(f);
        }
        reverse(fib);
        return fib;
    }
}
