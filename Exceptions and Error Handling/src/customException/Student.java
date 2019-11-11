package customException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void validateName(String name) {
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>0-9]+");
        Matcher matcher = pattern.matcher(name);

        if (matcher.find()){
            throw new InvalidPersonNameException();
        }

    }
}
