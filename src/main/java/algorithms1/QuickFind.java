package algorithms1;

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

        qf.printArray(qf.id);

        StdOut.println(qf.connected(0, 1));
        StdOut.println(qf.connected(9, 9));
        StdOut.println(qf.connected(9, 1));

        qf.id[5] = 99;
        qf.id[7] = 99;
        qf.id[9] = 100;

        StdOut.println(qf.connected(5, 7));

        qf.printArray(qf.id);

        qf.union(5, 9);

        qf.printArray(qf.id);
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
            StdOut.print(myArray[i]);
            StdOut.println();
        }
    }
}
