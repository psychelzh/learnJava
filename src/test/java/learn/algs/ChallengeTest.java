/*
 * ChallengeTest
 *
 * This is for personal use only, belongs to Liang Zhang.
 */

package learn.algs;

/**
 * The {@code ChallengTest} class is used to do tests for the challenges on
 * Sololearn courses.
 *
 * @author Liang Zhang
 */
public class ChallengeTest {
    public static class A {
        public String a1;

        public A(String a1) {
            this.a1 = a1;
        }
    }

    public static void main(String[] args) {
        A a = new A("1");
        A c = a;
        a = new A("3");
        System.out.print(a.a1);
        System.out.print(c.a1);
    }
}
