package database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    private Database database;
    private static final Integer[] invalidArray = new Integer[17];
    private static final Integer[] validArray = {1,2,3};

    private static final int VALUE_TO_ADD = 5;
    private static final int SEARCH_VALUE_AFTER_REMOVE = 3;

    @Test(expected = OperationNotSupportedException.class)
    public void initializeInvalidObject() throws OperationNotSupportedException {
        this.database = new Database(invalidArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeInvalidObjectZeroElements() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Before
    public void initializeDataBase() throws OperationNotSupportedException {
        this.database = new Database(validArray);
    }

    @Test
    public void validInitializeDataBase(){
        Integer[] elements = this.database.getElements();
        Assert.assertArrayEquals(validArray,elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodNull() throws OperationNotSupportedException {
        this.database.add(null);
    }


    @Test
    public void addMethodValidData() throws OperationNotSupportedException {
        this.database.add(VALUE_TO_ADD);
        Integer[] elements = this.database.getElements();
        Assert.assertEquals(VALUE_TO_ADD,elements[3].intValue());
    }

    @Test
    public void removeElement() throws OperationNotSupportedException {
        this.database.add(VALUE_TO_ADD);
        this.database.remove();
        Integer[] elements = this.database.getElements();
        Assert.assertEquals(SEARCH_VALUE_AFTER_REMOVE,elements[2].intValue());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeMoreElementsThanThereAre () throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }
}
