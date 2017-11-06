package febrary16;

import java.util.ArrayList;

/**
 * Created by Максим on 16.02.2017.
 */
public class ArrayListMap implements Map<String, Number> {
    private ArrayList<String> keys;
    private ArrayList<Object> values;

    public ArrayListMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public ArrayListMap(int length) {
        this.keys = new ArrayList<>(length);
        this.values = new ArrayList<>(length);
    }

    @Override
    public void add(String key, Object value) {
        checkKey(key);

        keys.add(key);
        values.add(value);
    }

    @Override
    public Object remove(String key) {
        checkKey(key);

        int index = keys.indexOf(key);

        Object obj = values.get(index);

        keys.remove(index);
        values.remove(index);

        return obj;
    }

    @Override
    public Object get(String key) {
        checkKey(key);

        int index = keys.indexOf(key);
        return values.get(index);
    }

    @Override
    public void set(String key, Object value) {
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
    public String[] getKeys() {
        return (String[]) keys.toArray();
    }

    @Override
    public Object[] getValues() {
        return values.toArray();
    }

    @Override
    public int size() {
        return keys.size();
    }

    private void checkKey(String key) throws KeyException{
        if (keys.contains(key)) throw new KeyException("Key already exist");
    }
}
