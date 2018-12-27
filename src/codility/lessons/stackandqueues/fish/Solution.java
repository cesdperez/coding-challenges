package codility.lessons.stackandqueues.fish;

import java.util.Stack;

public class Solution {

    public int solution(int[] A, int[] B) {
        Stack<Integer> upstream = new Stack<>();
        Stack<Integer> downstream = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) { //going upstream
                Integer downstreamFish = 0;
                Integer upstreamFish = A[i];
                while (!downstream.isEmpty() && upstreamFish > downstreamFish) {
                    downstreamFish = downstream.pop();
                }

                if (upstreamFish > downstreamFish) {
                    upstream.push(A[i]);
                } else {
                    downstream.push(downstreamFish);
                }
            } //going downstream
            if (B[i] == 1) {
                downstream.push(A[i]);
            }
        }
        return upstream.size() + downstream.size();
    }
}
