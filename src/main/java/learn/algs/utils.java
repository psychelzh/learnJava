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

    /**
     * Print a the contents of a two-dimensional boolean array, using * to
     * represent {@code true} and a space to represent {@code false}. Include
     * row and column numbers.
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
            }
            else if (colLengthThisRow != colLengthFirstRow) {
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
}
