package dynamicconnectivity;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] percolationThreshold;
    private int n;
    private int trials;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        this.n = n;
        this.trials = trials;

        percolationThreshold = new double[trials];

        for (int i = 0; i < this.trials; i++) {
            Percolation p = new Percolation(this.n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(1, this.n + 1);
                int col = StdRandom.uniform(1, this.n + 1);
//                StdOut.printf("row: %d, col: %d\n", row, col);
                p.open(row, col);
            }

            this.percolationThreshold[i] = p.numberOfOpenSites() / (double) (this.n * this.n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolationThreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percolationThreshold);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(trials));
    }

    // test client (described below)
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        StdOut.printf("mean                     = %f\n", ps.mean());
        StdOut.printf("stddev                   = %f\n", ps.stddev());
        StdOut.printf("95%% confidence interval  = %f, %f\n", ps.confidenceLo(), ps.confidenceHi());
        StdOut.println();
    }
}