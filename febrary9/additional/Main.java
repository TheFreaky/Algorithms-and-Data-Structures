package febrary9.additional;

/**
 * Created by Максим on 15.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            queue.push(new Task("" + i));
            stack.push(new Task("" + i));
        }

        doTasks(stack);
        doTasks(queue);
    }

    public static void doTasks(Sequence sequence) {
        while (sequence.size() > 0) {
            if(Task.isFinished()) {
                Task task = sequence.pop();
                System.out.println(task);
                task.run();
            }
        }
    }
}
