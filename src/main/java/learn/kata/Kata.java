/*
 * Kata Liang Zhang
 */

package learn.kata;

import java.util.LinkedList;

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
   * href=https://www.codewars.com/kata/coloured-triangles>Color triangles</a>. It returns the
   * result as {@code String} type.
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

  /**
   * The {@code duplicateCount} counts the number of Duplicates. It will return the count of
   * distinct case-insensitive alphabetic characters and numeric digits that occur more than once in
   * the input string.
   *
   * @param text The original string, should contain letters and numbers only.
   * @return The count of duplicate characters.
   */
  public static int duplicateCount(String text) {
    char[] textCharArray = text.toLowerCase().toCharArray();
    // use two separate lists to store unique characters and counts for each character
    LinkedList<Character> textCharsList = new LinkedList<Character>();
    LinkedList<Integer> textCharsCountList = new LinkedList<Integer>();
    // traverse through every character of the text and store the count results
    for (char textChar : textCharArray) {
      if (textCharsList.contains(textChar)) {
        int thisCharIndex = textCharsList.indexOf(textChar);
        textCharsCountList.set(thisCharIndex, textCharsCountList.get(thisCharIndex) + 1);
      } else {
        textCharsList.addLast(textChar);
        textCharsCountList.addLast(1);
      }
    }
    // count the dupliates (count > 1)
    int dupCount = 0;
    for (int count : textCharsCountList) {
      if (count > 1) {
        dupCount++;
      }
    }
    return dupCount;
  }

  /**
   * Given a positive integer n written as abcd... (a, b, c, d... being digits)
   * and a positive integer p we want to find a positive integer k, if it exists,
   * such as the sum of the digits of n taken to the successive powers of p is
   * equal to k * n.
   */
  public static long digPow(int n, int p) {
    String numString = String.valueOf(n);
    int powSum = 0;
    for (int i = 0; i < numString.length(); i++) {
      powSum += Math.pow((numString.charAt(i) - '0'), (p + i));
    }
    if (powSum % n == 0) {
      return powSum / n;
    } else {
      return -1;
    }
  }

}
