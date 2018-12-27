package codility.lessons.indeedprime2015challenge.longestpassword;

/**
 * https://app.codility.com/programmers/lessons/90-tasks_from_indeed_prime_2015_challenge/longest_password/
 */
public class Solution {

    public int solution(String S) {
        String[] words = S.split(" ");

        int result = -1;
        for (String word : words) {
            if (isValid(word)) {
                result = word.length() < result ? result : word.length();
            }
        }

        return result;
    }

    private boolean isValid(String word) {
        int letters = 0;
        int digits = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (isLetter(c)) {
                letters++;
            } else if (isDigit(c)) {
                digits++;
            } else {
                return false;
            }
        }

        boolean evenLetters = letters % 2 == 0;
        boolean oddDigits = digits % 2 != 0;

        return evenLetters && oddDigits;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
