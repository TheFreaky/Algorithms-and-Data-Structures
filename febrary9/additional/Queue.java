package febrary9.additional;

/**
 * Created by Максим on 09.02.2017.
 */
public class Queue implements Sequence {
    private int length;
    Task[] arr;

    public Queue() {
        length = 0;
        arr = new Task[length];
    }

    @Override
    public void push(Task task) {
        Task[] newArr = new Task[length + 1];
        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
        arr[length] = task;

        length++;
    }

    @Override
    public Task pop() {
        length--;
        Task task = arr[0];

        Task[] newArr = new Task[length];
        System.arraycopy(arr, 1, newArr, 0, length);
        arr = newArr;

        return task;
    }

    @Override
    public int size() {
        return length;
    }
}
