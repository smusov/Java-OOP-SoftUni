package extendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests {

    private static final Person[] INVALID_PERSON_ARRAY = new Person[17];
    private static final Person[] INVALID_PERSON_ARRAY_ZERO_PERSON = new Person[0];
    private static final Person[] VALID_PERSON_ARRAY = {new Person(42, "First Person"), new Person(69, "Second Person")};

    private static final String PERSON_NAME = "Third Person";
    private static final int PERSON_ID = 79;

    private static final int NEEDED_ARRAY_LENGTH = 3;

    private static final String NOT_EQUALS_OBJECTS = "Searched object and return of database object not same!";
    private static final String NOT_ADDED_OBJECT = "Object not added to database!";
    private static final String NO_REMOVED_OBJECTS = "Method remove not working correct!";

    private Database database;
    private Person person;

    @Test(expected = OperationNotSupportedException.class)
    public void initializeInvalidDataBaseMorePersonOfTheLimit() throws OperationNotSupportedException {
        this.database = new Database(INVALID_PERSON_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeInvalidDataBaseLessPersonOfTheLimit() throws OperationNotSupportedException {
        this.database = new Database(INVALID_PERSON_ARRAY_ZERO_PERSON);
    }

    @Before
    public void initializeDataBase() throws OperationNotSupportedException {
        this.database = new Database(VALID_PERSON_ARRAY);
    }

    @Before
    public void initializePerson() {
        this.person = new Person(PERSON_ID, PERSON_NAME);
    }

    @Test
    public void addPersonToDataBase() throws OperationNotSupportedException {
        this.database.add(this.person);
        Assert.assertEquals(NOT_ADDED_OBJECT, NEEDED_ARRAY_LENGTH, this.database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullValue() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void findPersonByUsername() throws OperationNotSupportedException {
        this.database.add(this.person);
        Person p = this.database.findByUsername(PERSON_NAME);
        Assert.assertEquals(NOT_EQUALS_OBJECTS, this.person, p);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByNameInvalidNullValue() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findNonExistentPersonName() throws OperationNotSupportedException {
        this.database.findByUsername("Test");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findMoreOnePersonWithGivenNameInvalidOperation() throws OperationNotSupportedException {
        this.database.add(this.person);
        this.database.add(this.person);
        this.database.findByUsername(PERSON_NAME);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeMoreObjectsThanThereAre() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void removeObject() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertEquals(NO_REMOVED_OBJECTS,1,this.database.getElements().length);
    }
    @Test
    public void removesAvailableObjects() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
        Assert.assertEquals(NO_REMOVED_OBJECTS,0,this.database.getElements().length);
    }

    @Test
    public void findPersonById() throws OperationNotSupportedException {
        this.database.add(this.person);
        Person p = this.database.findById(79);
        Assert.assertEquals(NOT_EQUALS_OBJECTS,this.person,p);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryFindNonExistentObject() throws OperationNotSupportedException {
        this.database.findById(99);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findMoreOnePersonWithGivenIdInvalidOperation() throws OperationNotSupportedException {
        this.database.add(new Person(69,"Test"));
        this.database.findById(69);
    }
}
