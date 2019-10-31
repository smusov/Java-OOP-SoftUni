package solidLab.p05_DependencyInversion.p02_Worker;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager(new Robot());
        Manager manager2 = new Manager(new Worker());
    }
}
