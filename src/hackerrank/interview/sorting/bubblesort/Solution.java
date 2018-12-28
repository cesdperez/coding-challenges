package hackerrank.interview.sorting.bubblesort;

/** https://www.hackerrank.com/challenges/ctci-bubble-sort/problem **/
public class Solution {

    static void countSwaps(int[] a) {
        int swaps = sortAndCountSwaps(a);
        System.out.printf("Array is sorted in %s swaps.%n", swaps);
        System.out.printf("First Element: %s%n", a[0]);
        System.out.printf("Last Element: %s%n", a[a.length - 1]);
    }

    static int sortAndCountSwaps(int[] a) {
        if (a == null)
            return 0;

        int swaps = 0;
        boolean isSorted = false;
        int lastUnsorted = a.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    swaps++;
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }

        return swaps;
    }

    private static void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}
