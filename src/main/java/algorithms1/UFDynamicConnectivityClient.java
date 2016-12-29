package algorithms1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

import java.io.File;

/**
 * Created by muthu on 12/28/16.
 */
public class UFDynamicConnectivityClient {
    public static void main(String[] args) {
        File file = new File(args[0]);
        In in = new In(file);
        int N = in.readInt();
        UF uf = new UF(N);
        while (in.hasNextLine()) {
            int p = in.readInt();
            int q = in.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            } else {
                StdOut.println(p + " -NOT CONNECTED- " + q);
            }
        }
    }
}
