package iteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {

    private ListIterator listIterator;

    @Test(expected = OperationNotSupportedException.class)
    public void initialiseInvalidListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Before
    public void initialiseListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Test","Test2");
    }

    @Test
    public void moveInternalIndex(){
        boolean move = this.listIterator.move();
        Assert.assertTrue(move);
    }

    @Test
    public void moveInternalIndexMoreTimesThanThereAreItems(){
        this.listIterator.move();
        this.listIterator.move();
        boolean move = this.listIterator.move();
        Assert.assertFalse(move);
    }

    @Test
    public void hasNextElement(){
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertTrue(hasNext);
    }

    @Test
    public void noMoreNextElements() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertFalse(hasNext);
    }

    @Test
    public void thereAreNextElements(){
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertTrue(hasNext);
    }

    @Test(expected = IllegalStateException.class)
    public void printEmptyListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    @Test
    public void printElement(){
        String print = this.listIterator.print();
        Assert.assertEquals("Test",print);
    }
}
