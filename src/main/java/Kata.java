/*
 * Kata Liang Zhang
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * The {@code Kata} class is used to record all my solutions and tests on <a
 * href=https://www.codewars.com>Codewars Challenges</a>.
 *
 * @author Liang Zhang
 */
public class Kata {

  /**
   * This is the major method used to solve the problem <a
   * href=https://www.codewars.com/kata/coloured-triangles>Color triangles</a>.
   *
   * @param row The first row of the triangle as {@code String} type.
   * @return The final color which would appear in the bottom row as {@code char} type.
   */
  public static char triangle(final String row) {
    // Return the answer
    return triangleString(row).charAt(0);
  }

  /**
   * This is the real processing method to solve the problem <a
   * href=https://www.codewars.com/kata/coloured-triangles>Color triangles</a>.
   * It returns the result as {@code String} type.
   *
   * @param row The first row of the triangle as {@code String} type.
   * @return The final color which would appear in the bottom row as {@code String} type.
   */
  public static String triangleString(final String row) {
    // the base case
    if (row.length() <= 2) {
      return triangleNextRow(row);
    }
    // recursively calls the method
    return triangleString(triangleNextRow(row));
  }

  /**
   * This method is used to get the next row given a row of triangles.
   *
   * @param row The given row of the triangle as {@code String} type.
   * @return The next row of the triangles as {@code String} type.
   */
  public static String triangleNextRow(final String row) {
    // the base cases
    if (row.length() == 1) {
      return row;
    }
    if (row.length() == 2) {
      // a brute force approach to set the return values
      switch (row) {
        case "RR":
        case "GB":
        case "BG":
          return "R";
        case "BB":
        case "GR":
        case "RG":
          return "B";
        case "GG":
        case "BR":
        case "RB":
          return "G";
        default:
      }
    }
    // recursively calls this method
    return triangleNextRow(row.substring(0, 2)) + triangleNextRow(row.substring(1));
  }

  @Test
  public void testTriangle() {
    String row = "RGB";
    String special = "R";
    Assert.assertEquals('G', triangle(row));
    Assert.assertEquals('R', triangle(special));
  }

}
