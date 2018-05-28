/*
 * Percolation
 *
 * Author: Liang, Zhang
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * The {@code Percolation} class is implemented to complete the first program
 * assignment of algorithm course on coursera. See <a
 * href="http://coursera.cs.princeton.edu/algs4/assignments/percolation.html">
 * this page</a> for more information.
 */
public class Percolation {

  private WeightedQuickUnionUF sites; // represents all the sites
  private int dim; // number of rows/columns
  private boolean[] sitesIsOpen; // represents open status for all sites
  private int topVSite; // index of top virtual site
  private int bottomVSite; // index of bottom virtual site

  /**
   * Constructor method.
   *
   * <p>create n-by-n grid, with all sites blocked.
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
    // initialize as closed for all sites
    sitesIsOpen = new boolean[dim * dim];
    // there are two virtual sites
    sites = new WeightedQuickUnionUF(dim * dim + 2);
    // the last two sites is the virtual sites
    topVSite = dim * dim;
    bottomVSite = dim * dim + 1;
  }

  /**
   * Open site ({@code row}, {@code col}) if it is not open already.
   *
   * @param row row number index, starting from 1
   * @param col column number index, starting from 1
   * @throws IllegalArgumentException when row/column number is not between 1 and dim.
   */
  public void open(int row, int col) throws IllegalArgumentException {
    validate(row);
    validate(col);
    // mark the status of this site as open
    int thisSiteIndex = sub2ind(row, col);
    sitesIsOpen[thisSiteIndex] = true;
    // connect this site to all the adjacent open sites
    if (row > 1 && isOpen(row - 1, col)) {
      // not a site from the first row, connect to the upper site
      sites.union(thisSiteIndex, sub2ind(row - 1, col));
    }
    if (row < dim && isOpen(row + 1, col)) {
      // not a site from the last row, connect to the lower site
      sites.union(thisSiteIndex, sub2ind(row + 1, col));
    }
    if (col > 1 && isOpen(row, col - 1)) {
      // not a site from the first column, connect to the left site
      sites.union(thisSiteIndex, sub2ind(row, col - 1));
    }
    if (col < dim && isOpen(row, col + 1)) {
      // not a site from the last column, connect to the right site
      sites.union(thisSiteIndex, sub2ind(row, col + 1));
    }
    // connect site from the first row to top virtual site when open
    if (row == 1) {
      sites.union(thisSiteIndex, topVSite);
    }
    // connect any full site in the last row to the bottom virtual site
    for (int i = 1; i <= dim; i++) {
      if (isFull(dim, i)) {
        sites.union(sub2ind(dim, i), bottomVSite);
      }
    }
  }

  /**
   * Check whether site ({@code row}, {@code col}) is <b>open</b> or not.
   *
   * @param row row number index, starting from 1
   * @param col column number index, starting from 1
   * @return true if the site ({@code row}, {@code col}) is open
   * @throws IllegalArgumentException when row/column number is not between 1 and dim.
   */
  public boolean isOpen(int row, int col) throws IllegalArgumentException {
    validate(row);
    validate(col);
    return sitesIsOpen[sub2ind(row, col)];
  }

  /**
   * Check whether site ({@code row}, {@code col}) is <b>full</b> or not.
   *
   * @param row row number index, starting from 1
   * @param col column number index, starting from 1
   * @return true if the site ({@code row}, {@code col}) is full
   * @throws IllegalArgumentException when row/column number is not between 1 and dim.
   */
  public boolean isFull(int row, int col) throws IllegalArgumentException {
    validate(row);
    validate(col);
    return sites.connected(topVSite, sub2ind(row, col));
  }

  /**
   * Get the number of open sites.
   */
  public int numberOfOpenSites() {
    int count = 0;
    for (boolean siteIsOpen : sitesIsOpen) {
      if (siteIsOpen) {
        count++;
      }
    }
    return count;
  }

  /**
   * Check whether the system percolates or not.
   */
  public boolean percolates() {
    // the system percolates when the top and bottom virtual sites are connected
    return sites.connected(topVSite, bottomVSite);
  }

  // validate that p is a valid row/column index
  private void validate(int p) {
    if (p <= 0 || p > dim) {
      throw new IllegalArgumentException("index " + p + " is not between 1 and " + dim);
    }
  }

  // convert row/column index to site order index
  private int sub2ind(int row, int col) {
    validate(row);
    validate(col);
    return (row - 1) * dim + col - 1;
  }

  /**
   * Test client.
   */
  public static void main(String[] args) {}
}
