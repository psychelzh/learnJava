/*
 * KataTest
 * Liang Zhang
 */

package learn.kata;

import org.junit.Assert;
import org.junit.Test;

public class KataTest {

  @Test
  public void testTriangle() {
    String row = "RGB";
    String special = "R";
    Assert.assertEquals('G', Kata.triangle(row));
    Assert.assertEquals('R', Kata.triangle(special));
  }

  @Test
  public void testDupCount() {
    Assert.assertEquals(0, Kata.duplicateCount("abcde"));
    Assert.assertEquals(1, Kata.duplicateCount("abcdea"));
  }

  @Test
  public void testDigPow() {
    Assert.assertEquals(1, Kata.digPow(89, 1));
    Assert.assertEquals(51, Kata.digPow(46288, 3));
  }
}
