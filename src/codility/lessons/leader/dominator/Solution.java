package codility.lessons.leader.dominator;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 */
public class Solution {

    public int solution(int[] A) {

        int candidate = -1;
        int size = 0;
        for (int a : A) {
            if (size == 0) {
                size++;
                candidate = a;
            } else {
                size = (candidate == a) ? size + 1 : size - 1;
            }
        }

        int count = 0;
        int result = -1;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (a == candidate) {
                count++;
                result = i;
            }
        }

        if (count > A.length / 2) return result;
        else return -1;
    }
}
