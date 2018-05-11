package learn.algs;
import edu.princeton.cs.algs4.*;
import org.junit.Test;
public class problemTest {
    @Test
    public void test117a() {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }
}
