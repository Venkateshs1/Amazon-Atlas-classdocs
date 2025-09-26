package Day25.CommandPattern;

public class DontDoTask implements Command{
    private Task task;

    public DontDoTask(Task task) {
        this.task = task;
    }


    public void doIt() {
        this.task.dont();
    }
}
