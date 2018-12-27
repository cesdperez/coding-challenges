package cesdperez.codingchallenges.codility.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class OddOccurrencesInArray {

    public int solution(int[] A) {

        int N = A.length;
        if (N % 2 == 0) return -1;

        Set<Integer> solution = new HashSet<>();

        for (int a : A) {
            compute(solution, a);
        }

        return solution.iterator().hasNext() ? solution.iterator().next() : -1;
    }

    private void compute(Set<Integer> solution, int a) {
        if (solution.contains(a))
            solution.remove(a);
        else
            solution.add(a);
    }

    public int solutionON2(int[] A) {

        int N = A.length;
        if (N % 2 == 0) return -1;

        for (int a : A) {
            int repetitions = 0;
            for (int b : A)
                if (b == a) repetitions++;

            if (repetitions == 1) return a;
        }

        return -1;
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 2, 1, 3}); //3
        test(new int[]{1, 1, 4, 4, 2}); //2
        test(new int[]{3, 4, 3, 4, 1}); //1
        test(new int[]{3, 4, 1000000000, 1000000000, 3, 4, 1}); //1
    }

    private static void test(int[] A) {
        OddOccurrencesInArray solution = new OddOccurrencesInArray();
        int s = solution.solution(A);
        System.out.printf("solution for A=%s is: %s", Arrays.toString(A), s);
        System.out.println();
    }
}