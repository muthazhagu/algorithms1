
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int numberOfClosedSites;
    private final int gridSize;
    WeightedQuickUnionUF wquf;
    private int virtualUpper;
    private int virtualLower;

    public Percolation(final int n) {
        if (n <= 0) throw new IllegalArgumentException();

        // StdOut.printf("Creating a grid of size [%d][%d]\n", n, n);
        grid = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

        gridSize = n;
        numberOfClosedSites = n * n;
        // StdOut.printf("Grid size is [%d]\n", n);
        // StdOut.printf("Number of closed sites is [%d]\n", numberOfClosedSites);

        virtualUpper = n * n;
        virtualLower = n * n + 1;
        // StdOut.printf("Virtual Upper is [%d]\n", virtualUpper);
        // StdOut.printf("Virtual Lower is [%d]\n", virtualLower);

        wquf = new WeightedQuickUnionUF(n * n + 2);

        // StdOut.printf("Before doing any unions, are the virtual upper, and lower connected? %b\n", wquf.connected(virtualUpper, virtualLower));

        // Connect upper row to virtualUpper
        for (int i = 0; i < n; i++) {
            // StdOut.printf("Union %d, %d\n", i, virtualUpper);
            wquf.union(i, virtualUpper);
        }

        // Connect lower row to virtualLower
        for (int i = (n * n - n); i < n * n; i++) {
            // StdOut.printf("Union %d, %d\n", i, virtualLower);
            wquf.union(i, virtualLower);
        }

        // StdOut.printf("Component identifier for %d is %d\n", 0, wquf.find(0));
        // StdOut.printf("Component identifier for %d is %d\n", 1, wquf.find(1));
        // StdOut.printf("Component identifier for %d is %d\n", 9, wquf.find(9));
        // StdOut.printf("Component identifier for %d is %d\n", 10, wquf.find(10));
        // StdOut.printf("Component identifier for %d is %d\n", 100, wquf.find(100));
        // StdOut.printf("Component identifier for %d is %d\n", 89, wquf.find(89));
        // StdOut.printf("Component identifier for %d is %d\n", 90, wquf.find(90));
        // StdOut.printf("Component identifier for %d is %d\n", 98, wquf.find(98));
        // StdOut.printf("Component identifier for %d is %d\n", 99, wquf.find(99));
        // StdOut.printf("Component identifier for %d is %d\n", 101, wquf.find(101));

        // StdOut.printf("After doing unions, are the virtual upper, and lower connected? %b\n", wquf.connected(virtualUpper, virtualLower));
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        checkBounds(row, col);

        if (!grid[row][col]) {
            grid[row][col] = true;
            numberOfClosedSites -= 1;
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkBounds(row, col);
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        checkBounds(row, col);
        return isOpen(row, col) && wquf.connected(get1DArrayPosition(row, col), virtualUpper);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return gridSize * gridSize - numberOfClosedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return wquf.connected(virtualLower, virtualUpper);
    }

    private void checkBounds(int row, int col) {
        if (row < 0 || col < 0 || row >= gridSize || col >= gridSize) throw new IndexOutOfBoundsException();
    }

    int get1DArrayPosition(int row, int col) {
        return gridSize * row + col;
    }

    // test client (optional)
    public static void main(String[] args) {
//        Percolation p = new Percolation(10);

//        StdOut.printf("Is %d, %d full before opening? %b\n", 0, 0, p.isFull(0, 0));
//        p.open(0, 0);
//        StdOut.printf("Is %d, %d full after opening? %b\n", 0, 0, p.isFull(0, 0));
//        p.open(1, 0);
//        StdOut.printf("Is %d, %d full after opening? %b\n", 1, 0, p.isFull(1, 0));
//        StdOut.printf("Is %d, %d connected to virtual upper? %b\n", 1, 0, p.wquf.connected(p.get1DArrayPosition(1, 0), p.virtualUpper));
//        p.wquf.union(p.get1DArrayPosition(1, 0), p.virtualUpper);
//        StdOut.printf("Is %d, %d connected to virtual upper? %b\n", 1, 0, p.wquf.connected(p.get1DArrayPosition(1, 0), p.virtualUpper));
//        StdOut.printf("Does the system percolate? %b\n", p.percolates());
//        p.wquf.union(p.virtualLower, p.virtualUpper);
//        StdOut.printf("Does the system percolate? %b\n", p.percolates());
    }
}