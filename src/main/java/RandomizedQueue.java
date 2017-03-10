
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q = (Item[]) new Object[1];
    private int n = 0;
    private int tail = 0;

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

        if (n == q.length) {
            resize(2 * q.length);
        }

        q[tail++] = item;
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        StdRandom.shuffle(q);
        Item item = q[--tail];
        q[tail] = null;
        n--;

        if (n == q.length/4) {
            resize(q.length/2);
        }

        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return q[StdRandom.uniform(n)];
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
}
