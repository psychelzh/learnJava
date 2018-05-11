package learn.algs;
import edu.princeton.cs.algs4.*;
import org.junit.Test;
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
}
