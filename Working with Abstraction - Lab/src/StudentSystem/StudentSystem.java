package StudentSystem;

public class StudentSystem {

    private StudentData data;

    public StudentSystem() {
        this.data = new StudentData();
    }

    public StudentData getRepo() {
        return this.data;
    }

    public void ParseCommand(String[] args) {

        switch (args[0]){
            case "Create":
                createStudent(args);
                break;
            case "Show":
                showStudent(args[1]);
                break;
        }
    }

    private void createStudent (String[] args){

        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        if (!this.data.containsStudent(name)) {

            Student student = new Student(name, age, grade);
            data.addStudent(name, student);

        }
    }

    private void showStudent(String name){

        if (data.containsStudent(name)) {

            Student student = data.getStudent(name);
            System.out.println(student);
        }

    }
}
