package learn.algs;

/**
 * The {@code utils} is used to store a library of useful static methods used to
 * do excercises in the algorithm book.
 *
 * @author Liang Zhang
 */
public class utils {
    /**
     * Translate an integer number to a string of its binary representation.
     *
     * It should be the same as {@link Integer#toBinaryString(int)}.
     *
     * @param i input integer
     * @return the binary representation string
     */
    public static String myToBinaryString(int i) {
        String s = "";
        for (int iLoop = i; iLoop != 0; iLoop /= 2) {
            s = iLoop % 2 + s;
        }
        return s;
    }

}
