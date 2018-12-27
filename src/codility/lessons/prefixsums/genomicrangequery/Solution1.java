package codility.lessons.prefixsums.genomicrangequery;

import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * This one gets 87%
 */
public class Solution1 {

    private Map<Character, Integer> values;
    private Map<Character, SortedSet<Integer>> positions;

    public int[] solution(String S, int[] P, int[] Q) {
        loadValues();
        bufferPositions(S);

        int M = P.length;
        int[] result = new int[M];

        for (int m = 0; m < M; m++) {
            result[m] = computeMin(P[m], Q[m]);
        }

        return result;
    }

    private void loadValues() {
        values = new LinkedHashMap<>();
        values.put('A', 1);
        values.put('C', 2);
        values.put('G', 3);
        values.put('T', 4);
    }

    private void bufferPositions(String S) {
        positions = new Hashtable<>();
        positions.put('A', new TreeSet<>());
        positions.put('C', new TreeSet<>());
        positions.put('G', new TreeSet<>());
        positions.put('T', new TreeSet<>());

        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            positions.get(s).add(i);
        }
    }

    private int computeMin(int start, int end) {
        for (char s : values.keySet()) {
            if (contains(s, start, end)) {
                return values.get(s);
            }
        }
        return 4;
    }

    private boolean contains(char a, int start, int end) {
        SortedSet<Integer> p = positions.get(a);

        if (p.contains(start) || p.contains(end)) return true;

        SortedSet<Integer> tail = p.tailSet(start);
        if (tail.isEmpty()) return false;

        Integer firstMax = tail.first();
        return firstMax < end;
    }
}
