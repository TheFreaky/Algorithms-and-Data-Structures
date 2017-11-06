package febrary28;

/**
 * Created by Максим on 09.02.2017.
 */
public class Stack<T> implements Sequence<T> {
    private int length;
    private Object[] arr;

    public Stack() {
        length = 0;
        arr = new Object[length];
    }

    @Override
    public void push(T obj) {
        Object[] newArr = new Object[length + 1];
        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
        arr[length] = obj;

        length++;
    }

    @Override
    public T pop() {
        length--;
        Object obj = arr[length];

        Object[] newArr = new Object[length];
        System.arraycopy(arr, 0, newArr, 0, length);
        return (T) obj;
    }

    @Override
    public int size() {
        return length;
    }
}
