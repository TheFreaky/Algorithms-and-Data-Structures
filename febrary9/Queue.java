package febrary9;

/**
 * Created by Максим on 09.02.2017.
 */
public class Queue implements Sequence {
    private int length;
    Object[] arr;

    public Queue() {
        length = 0;
        arr = new Object[length];
    }

    @Override
    public void push(Object obj) {
        Object[] newArr = new Object[length + 1];
        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
        arr[length] = obj;

        length++;
    }

    @Override
    public Object pop() {
        length--;
        Object obj = arr[0];

        Object[] newArr = new Object[length];
        System.arraycopy(arr, 1, newArr, 0, length);
        return obj;
    }

    @Override
    public int size() {
        return length;
    }
}
