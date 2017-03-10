
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);

        String s;

        RandomizedQueue<String> r = new RandomizedQueue<>();

        while ((s = StdIn.readString()) != null) {
            System.out.println(s);
            r.enqueue(s);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(r.dequeue());
        }
    }
}
