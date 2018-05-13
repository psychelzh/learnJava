package learn.algs;

import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;

/**
 * This class is used to test all the code exercises for algs4.
 *
 * Each test is named as {@code test_#_#_#[_#]}, in which {@code #_#_#[_#]}
 * represents the exercise order, e.g., {@code 1_1_7_a} means exercise
 * {@code 1.1.7.a}. The last identifier (e.g. {@code _a}) could be ignored if
 * there is only one problem for that exercise.
 *
 * @author Liang Zhang
 */
public class exerciseTest {

    // test for 1.1.7a
    @Test
    public void test_1_1_7_a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    // test for 1.1.7b
    @Test
    public void test_1_1_7_b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        // Here I am wrong!
        Assert.assertEquals(499500, sum);
    }

    /**
     * Test for 1.1.9, to test method {@link utils#myToBinaryString(int)}.
     */
    @Test
    public void test_1_1_9() {
        int integerTest = (int) (Math.random() * 100);
        Assert.assertEquals(Integer.toBinaryString(integerTest), utils.myToBinaryString(integerTest));
    }

    /**
     * Test for 1.1.11, this test will show output. The method is
     * {@link utils#printBools(boolean[][])}.
     */
    @Test
    public void test_1_1_11() {
        boolean[][] bools = { { true, true, false, true }, { true, false, true, true } };
        utils.printBools(bools);
    }

    /**
     * Code fragment and test for 1.1.13.
     */
    @Test
    public void test_1_1_13() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        int M = matrix.length; // row number
        int N = matrix[0].length; // column number
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < M; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * This method {@code mystery} is from exercise 1.1.18. I believe it is used
     * to calculate and return the product of two integer input argument.
     *
     * @param a
     * @param b
     * @return the product of a and b
     */
    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    @Test
    public void test_1_1_18() {
        Assert.assertEquals(50, mystery(2, 25));
        Assert.assertEquals(33, mystery(3, 11));
    }
}
