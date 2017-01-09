
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

        for (int i = 0; i < ps.trials; i++) {
            Percolation p = new Percolation(ps.n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(0, ps.n);
                int col = StdRandom.uniform(0, ps.n);
//                StdOut.printf("row: %d, col: %d\n", row, col);
                p.open(row, col);

                // find the site to the right of the current site (row, col + 1)
                // see if it is open
                // if open, union with the current site
                if (col + 1 < ps.n) {
                    if (p.isOpen(row, col + 1)) {
//                        StdOut.println("Site to the right is open!");
                        p.wquf.union(p.get1DArrayPosition(row, col), p.get1DArrayPosition(row, col + 1));
                    }
                }

                // find the site to the bottom of the current site (row + 1, col)
                // see if it is open
                // if open, union with the current site
                if (row + 1 < ps.n) {
                    if (p.isOpen(row + 1, col)) {
//                        StdOut.println("Site to the bottom is open!");
                        p.wquf.union(p.get1DArrayPosition(row, col), p.get1DArrayPosition(row + 1, col));
                    }
                }

                // find the site to the left of the current site (row, col - 1)
                // see if it is open
                // if open, union with the current site
                if (col - 1 >= 0) {
                    if (p.isOpen(row, col - 1)) {
//                        StdOut.println("Site to the left is open!");
                        p.wquf.union(p.get1DArrayPosition(row, col), p.get1DArrayPosition(row, col - 1));
                    }
                }

                // find the site to the top of the current site (row - 1 , col)
                // see if it is open
                // if open, union with the current site
                if (row - 1 >= 0) {
                    if (p.isOpen(row - 1, col)) {
//                        StdOut.println("Site to the top is open!");
                        p.wquf.union(p.get1DArrayPosition(row, col), p.get1DArrayPosition(row - 1, col));
                    }
                }
            }
            ps.percolationThreshold[i] = p.numberOfOpenSites() / (double) (ps.n * ps.n);
        }

        StdOut.printf("mean                     = %f\n", ps.mean());
        StdOut.printf("stddev                   = %f\n", ps.stddev());
        StdOut.printf("95%% confidence interval  = %f, %f\n", ps.confidenceLo(), ps.confidenceHi());
        StdOut.println();
    }
}