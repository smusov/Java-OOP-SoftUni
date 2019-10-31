package solidLab.p05_DependencyInversion.p03_Database;

public class Courses {
    private Data database;

    public Courses(Data database) {
        this.database = database;
    }

    public void printAll() {
        Iterable<String> courses = this.database.courseNames();

        //print courses
    }

    public void printIds() {
        Iterable<Integer> coursesIds = this.database.courseIds();

        //print course ids
    }

    public void printById(int id) {
        String course = this.database.getCourseById(id);

        // print course
    }

    public void search(String substring) {
        Iterable<String> courses = this.database.search(substring);

        // print courses
    }
}
