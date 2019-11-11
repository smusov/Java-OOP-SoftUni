package validPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private void setFirstName(String firstName) {

        if (firstName==null||firstName.isBlank()){
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }

        this.firstName = firstName;
    }

    private void setLastName(String lastName) {

        if (lastName==null||lastName.isBlank()){
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }

        this.lastName = lastName;
    }

    private void setAge(int age) {

        if (age<0||age>120){
            throw new IllegalArgumentException("Age should be in the range [0 … 120]");
        }

        this.age = age;
    }
}
