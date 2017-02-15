package febrary9.additional;

/**
 * Created by Максим on 09.02.2017.
 */
public interface Sequence {
    void push(Task task);

    Task pop();

    int size();
}
