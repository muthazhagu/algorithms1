
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by muthu on 1/5/17.
 */
public class QuickUnion {
    private int[] id;
    private int count;

    public QuickUnion(int n){
        id = new int[n];
        count = n;

        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public int find(int index){
        while (index != id[index]){
            index = id[index];
        }

        return index;
    }

    public void union(int index1, int index2){
        int value1 = id[index1];
        int value2 = id[index2];

        if (value1 == value2){
            return;
        }

        id[index1] = value2;

        count--;
    }

    public boolean connected(int index1, int index2){
        return find(index1) == find(index2);
    }

    private void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            StdOut.printf("%d\t", myArray[i]);
        }

        StdOut.println();
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(11);

        StdOut.println("Program input");
        qu.printArray(qu.id);

        StdOut.println();
        StdOut.printf("Are 0 and 1 connected: %b\n", qu.connected(0, 1));
        StdOut.printf("Are 9 and 9 connected: %b\n", qu.connected(9, 9));
        StdOut.printf("Are 9 and 1 connected: %b\n", qu.connected(9, 1));

        qu.id[5] = 9;
        qu.id[7] = 9;
        qu.id[9] = 10;

        StdOut.println();
        StdOut.println("Changed input #1");
        qu.printArray(qu.id);

        StdOut.println();
        StdOut.printf("Are 5 and 7 connected: %b\n", qu.connected(5, 7));
        StdOut.printf("Are 7 and 9 connected: %b\n", qu.connected(7, 9));
        StdOut.printf("Are 9 and 5 connected: %b\n", qu.connected(9, 5));
        StdOut.printf("Are 0 and 1 connected: %b\n", qu.connected(0, 1));
        StdOut.printf("Are 9 and 9 connected: %b\n", qu.connected(9, 9));
        StdOut.printf("Are 9 and 1 connected: %b\n", qu.connected(9, 1));

        qu.union(5, 9);
        StdOut.println();
        StdOut.println("Changed input #2, after qu.union(5, 9)");
        qu.printArray(qu.id);

        StdOut.println();
        StdOut.printf("Are 5 and 7 connected: %b\n", qu.connected(5, 7));
        StdOut.printf("Are 7 and 9 connected: %b\n", qu.connected(7, 9));
        StdOut.printf("Are 9 and 5 connected: %b\n", qu.connected(9, 5));
        StdOut.printf("Are 9 and 0 connected: %b\n", qu.connected(9, 0));
        StdOut.printf("Are 0 and 1 connected: %b\n", qu.connected(0, 1));
        StdOut.printf("Are 9 and 9 connected: %b\n", qu.connected(9, 9));
        StdOut.printf("Are 9 and 1 connected: %b\n", qu.connected(9, 1));
    }
}
