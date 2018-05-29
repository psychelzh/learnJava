/*
 * ParcolationStats
 *
 * Author: Liang Zhang
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * .
 */
public class PercolationStats {

  private double[] thresholds;

  /**
   * Constructor: perform trials independent experiments on an n-by-n grid.
   *
   * @param n The dimension of the percolation system.
   * @param trials the number of trials.
   * @throws IllegalArgumentException if {@code n <= 0 || trials <=0}.
   */
  public PercolationStats(int n, int trials) throws IllegalArgumentException {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException("Either input 'n' or input 'trials' is not larger than 0");
    }
    // initiate all thresholds as 0
    thresholds = new double[trials];
    // for replication
    // StdRandom.setSeed(n);
    for (int trial = 0; trial < trials; trial++) {
      Percolation perc = new Percolation(n);
      while (!perc.percolates()) {
        // choose a random site to open
        int currentOpenSiteRow;
        int currentOpenSiteCol;
        do {
          currentOpenSiteRow = StdRandom.uniform(1, n + 1);
          currentOpenSiteCol = StdRandom.uniform(1, n + 1);
        } while (perc.isOpen(currentOpenSiteRow, currentOpenSiteCol));
        // open the choosen site
        perc.open(currentOpenSiteRow, currentOpenSiteCol);
      }
      // get the threshold for current trial
      thresholds[trial] = 1.0 * perc.numberOfOpenSites() / (n * n);
    }
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(thresholds);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(thresholds);
  }

  // low endpoint of 95% confidence interval
  public double confidenceLo() {
    return mean() - 1.96 * stddev() / Math.sqrt(thresholds.length);
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean() + 1.96 * stddev() / Math.sqrt(thresholds.length);
  }

  /**
   * Test client.
   *
   * @param args Two integer command line arguments are accepted. The first should be the dimension
   *             (default: {@code 200}) of the percolation system and the second should be the
   *             number of trials (default: {@code 100}).
   */
  public static void main(String[] args) {
    int n = 200;
    int trials = 100;
    if (args.length >= 1) {
      n = Integer.parseInt(args[0]);
    }
    if (args.length >= 2) {
      trials = Integer.parseInt(args[1]);
    }
    PercolationStats percStats = new PercolationStats(n, trials);
    System.out.println("mean                    = " + percStats.mean());
    System.out.println("stddev                  = " + percStats.stddev());
    System.out.println("95% confidence interval = [" + percStats.confidenceLo() + ", "
        + percStats.confidenceHi() + "]");
  }
}
