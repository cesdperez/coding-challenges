package codility.lessons.stackandqueues.stonewall;

import java.util.Stack;


/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 */
class Solution {

    public int solution(int[] H) {
        Stack<Integer> s = new Stack<>();

        int previous = H[0];
        int result = 1;
        for (int h : H) {
            if (previous > h) { //down
                Integer lastUp = s.isEmpty() ? -1 : s.pop();
                while (lastUp > h) {
                    lastUp = s.isEmpty() ? -1 : s.pop();
                }
                if (lastUp < h) {
                    result++;
                    s.push(lastUp);
                }
            } else if (previous < h) { //up
                result++;
            }
            previous = h;
            s.push(h);
        }
        return result;
    }
}
