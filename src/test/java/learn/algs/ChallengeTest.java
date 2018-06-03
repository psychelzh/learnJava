/*
 * ChallengeTest
 *
 * This is for personal use only, belongs to Liang Zhang.
 */

package learn.algs;

import org.junit.Test;

/**
 * The {@code ChallengTest} class is used to do tests for the challenges on
 * Sololearn courses.
 *
 * @author Liang Zhang
 */
public class ChallengeTest {

  // item begins
  public static class A {
    public String a1;

    public A(String a1) {
      this.a1 = a1;
    }
  }

  @Test
  public void test1() {
    A a = new A("1");
    A c = a;
    a = new A("3");
    System.out.print(a.a1);
    System.out.print(c.a1);
  }

  // item begins
  static void m(Object o) {
    System.out.print("object");
  }

  static void m(String s) {
    System.out.print("string");
  }

  @Test
  public void test2() {
    m(null);
  }

  // item begins
  class Executor {
    Executor() {
    }

    void Executor() {
      System.out.println("Welcome!");
    }
  }

  @Test
  public void test3() {
    Executor test = new Executor();
    test.Executor();
  }
}
