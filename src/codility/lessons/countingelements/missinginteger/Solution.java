package codility.lessons.countingelements.missinginteger;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class Solution {

    public int solution(int[] A) {
        int min = 1;
        Set<Integer> cache = new HashSet<>();

        for (int a : A) {
            if (a == min) {
                min++;
                while (cache.contains(min)) {
                    min++;
                }
            }
            if (a > min) {
                cache.add(a);
            }
        }

        return min;
    }
}
