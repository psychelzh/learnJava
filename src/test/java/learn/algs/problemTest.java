package learn.algs;
import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.*;
/**
 * This class is used to test all the code exercises for algs4.
 *
 * Each test is named as <code>test####</code>, in which <code>####</code>
 * represents the exercise order.
 */
public class problemTest {

    // test for 1.1.7a
    @Test
    public void test117a() {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    // test for 1.1.7b
    @Test
    public void test117b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        // Here I am wrong!
        Assert.assertEquals(499500, sum);
    }
}
