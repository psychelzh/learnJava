/*
 * ExerciseTest
 *
 * This is for personal use only, belongs to Liang Zhang.
 */

package learn.algs;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class is used to test all the code exercises for algs4.
 *
 * <p>Each test is named as {@code test_#_#_#[_#]}, in which {@code #_#_#[_#]}
 * represents the exercise order, e.g., {@code 1_1_7_a} means exercise
 * {@code 1.1.7.a}. The last identifier (e.g. {@code _a}) could be ignored if
 * there is only one problem for that exercise.
 *
 * @author Liang Zhang
 */
public class ExerciseTest {

  // test for 1.1.7a
  @Test
  public void test_1_1_7_a() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("%.5f\n", t);
  }

  // test for 1.1.7b
  @Test
  public void test_1_1_7_b() {
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
    // Here I am wrong!
    Assert.assertEquals(499500, sum);
  }

  /**
   * Test for 1.1.9, to test method {@link Utils#myToBinaryString(int)}.
   */
  @Test
  public void test_1_1_9() {
    int integerTest = (int) (Math.random() * 100);
    Assert.assertEquals(Integer.toBinaryString(integerTest), Utils.myToBinaryString(integerTest));
  }

  /**
   * Test for 1.1.11, this test will show output. The method is
   * {@link Utils#printBools(boolean[][])}.
   */
  @Test
  public void test_1_1_11() {
    boolean[][] bools = { { true, true, false, true }, { true, false, true, true } };
    Utils.printBools(bools);
  }

  /**
   * Code fragment and test for 1.1.13.
   */
  @Test
  public void test_1_1_13() {
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
    int m = matrix.length; // row number
    int n = matrix[0].length; // column number
    for (int col = 0; col < n; col++) {
      for (int row = 0; row < m; row++) {
        System.out.print(matrix[row][col]);
      }
      System.out.println();
    }
  }

  /**
   * This method {@code mystery} is from exercise 1.1.18. I believe it is used to
   * calculate and return the product of two integer input argument.
   *
   * @param a integer 1
   * @param b integer 2
   * @return the product of a and b
   */
  public static int mystery(int a, int b) {
    if (b == 0) {
      return 0;
    }
    if (b % 2 == 0) {
      return mystery(a + a, b / 2);
    }
    return mystery(a + a, b / 2) + a;
  }

  @Test
  public void test_1_1_18() {
    Assert.assertEquals(50, mystery(2, 25));
    Assert.assertEquals(33, mystery(3, 11));
  }

  /**
   * Test for 1.1.19, used method {@link Utils#F(int)}.
   */
  @Test
  public void test_1_1_19() {
    Assert.assertEquals(0, Utils.F(0));
    Assert.assertEquals(1, Utils.F(1));
    Assert.assertEquals(1, Utils.F(2));
    Assert.assertEquals(2, Utils.F(3));
    Assert.assertEquals(3, Utils.F(4));
  }
}
