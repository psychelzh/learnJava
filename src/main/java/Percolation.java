/*
 * Percolation Liang, Zhang
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  WeightedQuickUnionUF uf;
  int dim; // number of rows/columns

  /**
   * Constructor method.
   *
   * <p>create n-by-n grid, with all sites blocked
   *
   * @param n The number of rows/columns.
   * @throws IllegalArgumentException If the number of rows/columns input is not larger than 0, this
   *                                  error will be thrown.
   */
  public Percolation(int n) throws IllegalArgumentException {
    if (n <= 0) {
      throw new IllegalArgumentException("Invalid number of rows/columns");
    }
    // store the grid dimension (number of rows/coumns)
    dim = n;
    // there are two virtual sites
    uf = new WeightedQuickUnionUF(n * n + 2);
    for (int i = 1; i <= n; i++) {
      // the first element denotes the top virtual site, connect it to the top row
      uf.union(0, i);
      // the last element denotes the bottom virtual site, connect it to the bottom row
      uf.union(n * n + 1, n * n - i + 1);
    }
  }

  /**
   * Open site ({@code row}, {@code col}) if it is not open already.
   */
  public void open(int row, int col) {
    validate(row);
    validate(col);
  }

  /**
   * Check whether site ({@code row}, {@code col}) is <b>open</b> or not.
   */
  public boolean isOpen(int row, int col) {
    return false;
  }

  /**
   * Check whether site ({@code row}, {@code col}) is <b>full</b> or not.
   */
  public boolean isFull(int row, int col) {
    return false;
  }

  /**
   * Get the number of open sites.
   */
  public int numberOfOpenSites() {
    return 0;
  }

  /**
   * Check whether the system percolates or not.
   */
  public boolean percolates() {
    return false;
  }

  // validate that p is a valid row/column index
  private void validate(int p) {
    if (p <= 0 || p > dim) {
      throw new IllegalArgumentException("index " + p + " is not between 1 and " + dim);
    }
  }

  /**
   * Test client.
   */
  public static void main(String[] args) {}
}
