package dynamicconnectivity;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by muthu on 12/28/16.
 */
public class QuickFind {
    private int[] id;

    public QuickFind(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);

        StdOut.println("Program input");
        qf.printArray(qf.id);

        StdOut.println();
        StdOut.printf("Are 0 and 1 connected: %b\n", qf.connected(0, 1));
        StdOut.printf("Are 9 and 9 connected: %b\n", qf.connected(9, 9));
        StdOut.printf("Are 9 and 1 connected: %b\n", qf.connected(9, 1));

        qf.id[5] = 99;
        qf.id[7] = 99;
        qf.id[9] = 100;

        StdOut.println();
        StdOut.println("Changed input #1");
        qf.printArray(qf.id);

        StdOut.println();
        StdOut.printf("Are 5 and 7 connected: %b\n", qf.connected(5, 7));

        qf.union(5, 9);
        StdOut.println();
        StdOut.println("Changed input #2, after qf.union(5, 9)");
        qf.printArray(qf.id);

        StdOut.println();
        StdOut.printf("Are 5 and 7 connected: %b\n", qf.connected(5, 7));
        StdOut.printf("Are 7 and 9 connected: %b\n", qf.connected(7, 9));
        StdOut.printf("Are 9 and 5 connected: %b\n", qf.connected(9, 5));
        StdOut.printf("Are 9 and 0 connected: %b\n", qf.connected(9, 0));
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    private void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            StdOut.printf("%d\t", myArray[i]);
        }

        StdOut.println();
    }
}
