import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by muthu on 1/25/17.
 */
public class RandomizedQueueTest {
    private RandomizedQueue<String> q;

    private boolean verifyCount() {
        int count = 0;

        for (String s: q) {
            count += 1;
        }

        return count == q.size();
    }

    @Before
    public void setup() {
        q = new RandomizedQueue<>();
        assert q.isEmpty();
    }

    @After
    public void teardown() {
        verifyCount();
    }

    @Test
    public void enqOneItem() {
        q.enqueue("One");
        assert !q.isEmpty();
        assert q.size() == 1;
        assert q.sample().equals("One");

        Iterator myIterator = q.iterator();

        while (myIterator.hasNext()) {
            assert myIterator.next().equals("One");
        }
    }

    @Test
    public void enqTwoItems() {
        q.enqueue("One");
        q.enqueue("Two");
        assert q.size() == 2;

        Iterator myIterator = q.iterator();

        while (myIterator.hasNext()) {
            assert myIterator.next().equals("One");
            assert myIterator.next().equals("Two");
        }
    }

    @Test(expected = NullPointerException.class)
    public void addNullItemTest() {
        q.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void sampleWhenEmptyTest() {
        q.sample();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorRemoveTest() {
        q.enqueue("One");

        Iterator myIterator = q.iterator();
        myIterator.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextTest() {
        Iterator myIterator = q.iterator();
        myIterator.next();

        q.enqueue("One");

        assert myIterator.next().equals("One");
        myIterator.next();
    }
}
