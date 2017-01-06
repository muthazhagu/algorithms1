
/**
 * Created by muthu on 1/5/17.
 */
public class WeightedQuickUnion {
    private int count;
    private int[] id;

    public WeightedQuickUnion(int n){
        count = n;
        id = new int[n];

        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public boolean connected(int index1, int index2){
        return find(index1) == find(index2);
    }

    public int count(){
        return count;
    }

    public int find(int index){
        return 0;
    }

    public void union(int index1, int index2){

    }
}
