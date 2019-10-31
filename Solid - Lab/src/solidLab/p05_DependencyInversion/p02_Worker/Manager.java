package solidLab.p05_DependencyInversion.p02_Worker;

public class Manager {

    private Workable worker;

    public Manager(Workable worker) {
        this.worker = worker;
    }
    private void work (){
        this.worker.work();
    }
}
