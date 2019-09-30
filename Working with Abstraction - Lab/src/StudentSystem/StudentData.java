package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentData {
    private Map<String, Student> data;

    public StudentData() {
        this.data = new HashMap<>();
    }

    public Student getStudent (String name){
        return this.data.get(name);
    }

    public void addStudent(String name ,Student student){
        this.data.put(name,student);
    }
    public boolean containsStudent (String name){
        return data.containsKey(name);
    }
}
