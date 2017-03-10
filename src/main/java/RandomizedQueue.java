
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q = (Item[]) new Object[1];
    private int n = 0;
//    private int tail = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

//        System.out.println("Value of n: " + n);
        if (n == q.length) {
            resize(2 * q.length);
        }

        q[n++] = item;
//        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
//        Item item = null;
//        boolean sentinel = true;
        
//        while (sentinel) {
//            int index = StdRandom.uniform(n);
//            item = q[index];
//            if (item != null) {
//                sentinel = false;
//                q[index] = null;
//            }
//        }
        
        int index = StdRandom.uniform(n);
        Item item = q[index];
        Item last = q[n-1];
        Item temp = last;
        last = item;
        item = temp;

        q[--n] = null;

        if (n > 0 && n == q.length/4) {
            resize(q.length/2);
        }

//        System.out.println("Outside While Loop");
//        System.out.println("item " + item);
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        Item item = null;
        
        boolean sentinel = true;
        
        while (sentinel) {
            item = q[StdRandom.uniform(n)];
            if (item != null) {
                sentinel = false;
            }
        }
        
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];

        for (int i = 0; i < n; i++) {
            temp[i] = q[i];
        }

        q = temp;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != n;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item item = q[index];
            index += 1;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
//    public static void main(String[] args) {
//        RandomizedQueue<Integer> r = new RandomizedQueue<>();
//        r.enqueue(100);
//        r.enqueue(1);
//        r.enqueue(12);
//        r.enqueue(13);
//        r.enqueue(4);
//        r.enqueue(5);
//        r.enqueue(60);
//        r.enqueue(78);
//        r.enqueue(9);
//        System.out.println(r.dequeue());
////        System.out.println(r.dequeue());
//        r.enqueue(1000);
//        System.out.println(r.dequeue());
//        System.out.println(r.size());
//        r.enqueue(2000);
//        System.out.println(r.size());
//    }
}
