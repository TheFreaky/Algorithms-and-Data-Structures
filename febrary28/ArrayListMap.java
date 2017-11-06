package febrary28;

import java.util.ArrayList;

/**
 * Created by Максим on 16.02.2017.
 */
public class ArrayListMap<K, V> implements Map<K, V> {
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public ArrayListMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public ArrayListMap(int length) {
        this.keys = new ArrayList<>(length);
        this.values = new ArrayList<>(length);
    }

    @Override
    public void add(K key, V value) {
        checkKey(key);

        keys.add(key);
        values.add(value);
    }

    @Override
    public Object remove(K key) {
        checkKey(key);

        int index = keys.indexOf(key);

        Object obj = values.get(index);

        keys.remove(index);
        values.remove(index);

        return obj;
    }

    @Override
    public Object get(K key) {
        checkKey(key);

        int index = keys.indexOf(key);
        return values.get(index);
    }

    @Override
    public void set(K key, V value) {
        if (!keys.contains(key)) throw new KeyException("Key isn't exist");

        int index = keys.indexOf(key);
        values.set(index, value);
    }

    @Override
    public void removeAll() {
        keys.clear();
        values.clear();
    }

    @Override
    public K[] getKeys() {
        return (K[]) keys.toArray();
    }

    @Override
    public V[] getValues() {
        return (V[]) values.toArray();
    }

    @Override
    public int size() {
        return keys.size();
    }

    private void checkKey(K key) throws KeyException {
        if (keys.contains(key)) throw new KeyException("Key already exist");
    }
}
