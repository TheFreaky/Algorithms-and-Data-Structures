package febrary16;

import java.util.ArrayList;

/**
 * Created by Максим on 16.02.2017.
 */
public interface Map<S, I extends Number> {
    void add(String key, Object value);

    Object remove(String key);

    Object get(String key);

    void set(String key, Object value);

    void removeAll();

    String[] getKeys();

    Object[] getValues();

    int size();
}
