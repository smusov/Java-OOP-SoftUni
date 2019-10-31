package solidLab.p05_DependencyInversion.p02_Worker;

public class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("robot");
    }
}
