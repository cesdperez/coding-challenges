package hackerrank.java.lambdaexpressions

import spock.lang.Specification
import spock.lang.Unroll

class MyMathTest extends Specification {

    @Unroll
    def "it checks for odd numbers"(n, expected) {
        given:
        def myMath = new MyMath()

        expect:
        myMath.isOdd().check(n) == expected

        where:
        n || expected
        1 || true
        2 || false
    }

    @Unroll
    def "it checks for prime numbers"(n, expected) {
        given:
        def myMath = new MyMath()

        expect:
        myMath.isPrime().check(n) == expected

        where:
        n  || expected
        1  || false
        2  || true
        3  || true
        4  || false
        6  || false
        11 || true
    }

    @Unroll
    def "it checks for palindrome numbers"(n, expected) {
        given:
        def myMath = new MyMath()

        expect:
        myMath.isPalindrome().check(n) == expected

        where:
        n    || expected
        1    || true
        2    || true
        12   || false
        121  || true
        1211 || false
    }
}
