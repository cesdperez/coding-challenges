package hackerrank.interview.arrays.arrayds;

public class Solution {

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

//                System.out.print(sum + " ");
                max = max < sum ? sum : max;
            }
//            System.out.println();
        }
        return max;
    }
}
