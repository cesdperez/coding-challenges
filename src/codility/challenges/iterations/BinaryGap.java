package cesdperez.codingchallenges.codility.iterations;

import java.util.Arrays;
import java.util.Optional;

class BinaryGap {

    public int solution(int N) {
        String binary = Integer.toBinaryString(N);

        return solution(binary);
    }

    public int solution(String binary) {
        if (binary.length() <= 2) return 0;

        String[] split = binary.split("1");

        if (binary.startsWith("0")) split = dropFirst(split);
        if (binary.endsWith("0")) split = dropLast(split);

        Optional<Integer> max = Arrays.stream(split)
                .map(String::length)
                .max(Integer::compareTo);

        return max.orElse(0);
    }

    private String[] dropLast(String[] split) {
        return Arrays.copyOfRange(split, 0, split.length - 1);
    }

    private String[] dropFirst(String[] split) {
        return Arrays.copyOfRange(split, 1, split.length);
    }
}
