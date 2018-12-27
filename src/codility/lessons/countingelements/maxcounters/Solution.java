package codility.lessons.countingelements.maxcounters;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * <p>
 * The bottleneck is maxCounters operation.
 * I do an optimization by applying maxCounters lazily on each increment operation, if needed.
 * At the end I fix counters that weren't increased.
 */
public class Solution {

    private int[] counters;
    private int max;
    private int lastMax;

    public int[] solution(int N, int[] A) {
        counters = new int[N];
        max = 0;
        lastMax = 0;

        for (int X : A) {
            if (X <= N && X >= 1) {
                lazyMaxCounter(X);
                increase(X);
                updateMax(X);
            }
            if (X == N + 1) {
                updateLastMax();
            }
        }
        applyRemainingMaxCounters();

        return counters;
    }

    private void lazyMaxCounter(int X) {
        if (counters[X - 1] < lastMax)
            counters[X - 1] = lastMax;
    }

    private void increase(int X) {
        counters[X - 1]++;
    }

    private void updateMax(int X) {
        if (counters[X - 1] > max)
            max = counters[X - 1];
    }

    private void updateLastMax() {
        lastMax = max;
    }

    private void applyRemainingMaxCounters() {
        for (int i = 1; i < counters.length + 1; i++)
            lazyMaxCounter(i);
    }

}
