package febrary9.additional;

/**
 * Created by Максим on 15.02.2017.
 */
public class Task implements Runnable {

    private static boolean finished = true;

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public static boolean isFinished() {
        return finished;
    }

    @Override
    public void run() {
        try {
            finished = false;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finished = true;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
