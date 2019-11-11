package validPerson;

public class Main {
    public static void main(String[] args) {
        Person test = new Person("Unknown","Unknown",42);

        // Invalid test:

//        Person invalidFirstName = new Person("  ","Unknown",1);
//        Person invalidLastName = new Person("Unknown","       ",1);
//        Person invalidAge = new Person("Unknown","       ",-5);

        try {
            Person invalid = new Person("Unknown","Unknown",-5);
        }catch (IllegalArgumentException ex){
            System.out.println("Exception throw: "+ex.getMessage());
        }

    }
}
