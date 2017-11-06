import java.util.*;

/**
 * Created by Максим on 16.03.2017.
 */
public class MySet<T> extends AbstractSet<T>{
    private List<T> arr;

    public MySet() {
        arr = new ArrayList<>();
    }

    @Override
    public boolean add(T obj) {
        if (arr.contains(obj)) return false;

        return arr.add(obj);
    }

    @Override
    public boolean remove(Object obj) {
        return arr.remove(obj);
    }

    @Override
    public void clear() {
        arr.clear();
    }

    @Override
    public boolean contains(Object obj) {
        return arr.contains(obj);
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return arr.addAll(c);
    }

    @Override
    public Object[] toArray() {
        return arr.toArray();
    }

    @Override
    public Iterator<T> iterator() {
        return arr.iterator();
    }

    public int size() {
        return arr.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MySet<?> mySet = (MySet<?>) o;

        return arr.equals(mySet.arr);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + arr.hashCode();
        return result;
    }
}
