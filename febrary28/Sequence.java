package febrary28;

/**
 * Created by Максим on 09.02.2017.
 */
public interface Sequence<T> {
    void push(T obj);

    T pop();

    int size();
}
