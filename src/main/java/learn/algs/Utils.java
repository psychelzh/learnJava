/*
 * Utils
 *
 * This is for personal use only, belongs to Liang Zhang.
 */

package learn.algs;

/**
 * The {@code utils} is used to store a library of useful static methods used to
 * do excercises in the algorithm book.
 *
 * @author Liang Zhang
 */
public class Utils {
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

    /**
     * Print the contents of a two-dimensional boolean array, using * to represent
     * {@code true} and a space to represent {@code false}. Include row and column
     * numbers.
     *
     * @param bools input bool array
     */
    public static void printBools(boolean[][] bools) {
        for (int row = 0; row < bools.length; row++) {
            int colLengthFirstRow = bools[0].length;
            int colLengthThisRow = bools[row].length;
            // print the column numbers
            if (row == 0) {
                System.out.print(" ");
                for (int firstrow_col = 0; firstrow_col < bools[0].length; firstrow_col++)
                    System.out.print(firstrow_col + 1);
                System.out.println();
            } else if (colLengthThisRow != colLengthFirstRow) {
                throw new IllegalArgumentException(
                        "The input boolean array does not have the same number of columns for each row!");
            }
            for (int col = 0; col < colLengthFirstRow; col++) {
                // print the row numbers
                if (col == 0)
                    System.out.print(row + 1);
                if (bools[row][col])
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            // begin a new line after one row printing ends
            System.out.println();
        }
    }

    /**
     * Develop a better implementation of F(N) that saves computed values in an
     * array.
     *
     * This is to implement fibonacci series.
     *
     * @param N the order of the series.
     * @return the value of the series at the given order.
     */
    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        // using an array to store values, and the last value is the expected
        long[] f = new long[N + 1];
        // initialize the second value as 1
        f[1] = 1;
        for (int iloop = 2; iloop <= N; iloop++) {
            // number in new place is the sum of the two preceding values
            f[iloop] = f[iloop - 1] + f[iloop - 2];
        }
        return f[N];
    }
}
