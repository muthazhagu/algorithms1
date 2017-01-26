import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by muthu on 1/25/17.
 */
public class DequeTest {
    private Deque<String> d;

    private boolean verifyCount() {
        int count = 0;

        for (String s: d) {
            count += 1;
        }

        return count == d.size();
    }

    @Before
    public void setup() {
        d = new Deque<String>();
        assert d.size() == 0;
    }

    @After
    public void teardown() {
        assert verifyCount();
    }

    @Test
    public void addFirstOneItemTest() {
        d.addFirst("First item");
        assert d.size() == 1;

        for (String s : d) {
            assert s.equals("First item");
        }
    }

    @Test
    public void addFirstTwoItemsTest() {
        d.addFirst("First item");
        d.addFirst("Second item");
        assert d.size() == 2;

        for (String s : d) {
            assert s.equals("Second item");
            break;
        }
    }

    @Test
    public void addLastOneItemTest() {
        d.addLast("First item");
        assert d.size() == 1;

        for (String s : d) {
            assert s.equals("First item");
        }
    }

    @Test
    public void addLastTwoItemsTest() {
        d.addLast("First item");
        d.addLast("Second item");
        assert d.size() == 2;

        for (String s : d) {
            assert s.equals("First item");
            break;
        }
    }

    @Test
    public void removeFirstOneItemTest() {
        d.addFirst("First item");

        for (String s : d) {
            assert s.equals("First item");
        }

        assert (d.removeFirst().equals("First item"));
        assert d.size() == 0;
    }

    @Test
    public void removeFirstTwoItemsTest() {
        d.addFirst("First item");
        d.addFirst("Second item");

        assert (d.removeFirst().equals("Second item"));
        assert d.size() == 1;
    }

    @Test
    public void removeLastOneItemTest() {
        d.addLast("First item");

        for (String s : d) {
            assert s.equals("First item");
        }

        assert (d.removeLast().equals("First item"));
        assert d.size() == 0;
    }

    @Test
    public void removeLastTwoItemsTest() {
        d.addLast("First item");
        d.addLast("Second item");

        assert (d.removeLast().equals("Second item"));
        assert d.size() == 1;
    }

    @Test
    public void oneItemAddFirstRemoveLastTest() {
        d.addFirst("First");
        assert d.removeLast().equals("First");
        assert d.size() == 0;
    }

    @Test
    public void twoItemsAddFirstRemoveLastTest() {
        d.addFirst("First");
        d.addFirst("Second");
        assert d.removeLast().equals("First");
        assert d.size() == 1;
    }

    @Test
    public void oneItemAddLastRemoveFirstTest() {
        d.addLast("First");
        assert d.removeFirst().equals("First");
        assert d.size() == 0;
    }

    @Test
    public void twoItemsAddLastRemoveFirstTest() {
        d.addLast("First");
        d.addLast("Second");
        assert d.removeFirst().equals("First");
        assert d.size() == 1;
    }

    @Test
    public void twoItemsAddFirstAddLastRemoveFirstRemoveLast() {
        d.addFirst("First");
        d.addLast("Second");
        assert d.size() == 2;

        for (String s : d) {
            assert s.equals("First");
            break;
        }

        assert d.removeFirst().equals("First");
        assert d.removeLast().equals("Second");

        assert d.size() == 0;
    }

    @Test
    public void twoItemsAddFirstAddLastRemoveLastRemoveFirst() {
        d.addFirst("First");
        d.addLast("Second");
        assert d.size() == 2;

        for (String s : d) {
            assert s.equals("First");
            break;
        }

        assert d.removeLast().equals("Second");
        assert d.removeFirst().equals("First");

        assert d.size() == 0;
    }

    @Test
    public void twoItemsAddLastAddFirstRemoveLastRemoveFirst() {
        d.addLast("First");
        d.addFirst("Second");

        assert d.size() == 2;

        for (String s : d) {
            assert s.equals("Second");
            break;
        }

        assert d.removeLast().equals("First");
        assert d.removeFirst().equals("Second");

        assert d.size() == 0;
    }

    @Test
    public void twoItemsAddLastAddFirstRemoveFirstRemoveLast() {
        d.addLast("First");
        d.addFirst("Second");

        assert d.size() == 2;

        for (String s : d) {
            assert s.equals("Second");
            break;
        }

        assert d.removeFirst().equals("Second");
        assert d.removeLast().equals("First");

        assert d.size() == 0;
    }

    @Test
    public void removeFirstremoveFirstremoveLastremoveLastTest() {
        d.addFirst("A");
        d.addFirst("B");
        d.addLast("D");
        d.addLast("M");
        d.addFirst(" ");
        d.addFirst("Play ");
        d.addLast("INTON");

        assert d.size() == 7;

        assert d.removeFirst().equals("Play ");
        assert d.size() == 6;

        assert d.removeFirst().equals(" ");
        assert d.size() == 5;

        assert d.removeLast().equals("INTON");
        assert d.size() == 4;

        assert d.removeLast().equals("M");
        assert d.size() == 3;
    }

    @Test(expected = NullPointerException.class)
    public void addNullFirstTest() {
        d.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void addNullLastTest() {
        d.addLast(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeFirstFromEmptyDequeTest() {
        d.removeFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeLastFromEmptyDequeTest() {
        d.removeLast();
    }

    @Test
    public void cyclicalAddRemoveTest() {
        d.addFirst("First");
        d.addFirst("Second");

        assert d.removeFirst().equals("Second");
        assert d.removeFirst().equals("First");

        d.addLast("First");
        d.addLast("Second");

        assert d.removeLast().equals("Second");
        assert d.removeLast().equals("First");
    }
}
