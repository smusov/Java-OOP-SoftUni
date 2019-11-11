package customException;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("asd","asd@asd.asd");

        try {
            Student invalid = new Student("asd1","asd@asd.asd");
        }catch (InvalidPersonNameException ex){
            System.out.println(ex.getMessage());
        }
    }
}
