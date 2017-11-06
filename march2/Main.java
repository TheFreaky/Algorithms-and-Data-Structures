package march2;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Максим on 02.03.2017.
 */
public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> a = new MyLinkedList();
        for (int i = 0; i < 20; i++) {
            a.add(i);
        }
        a.add(null);
        show(a);

        a.removeObj(19);
        a.removeObj(null);

        show(a);

        System.out.println(a.get(0));
        System.out.println(a.has(18));

        MyLinkedList<Integer> b = new MyLinkedList();

        for (int i = 100; i > 50; i--) {
            b.add(i);
        }

        a.merge(b);
        show(a);
    }

    private static <T> void show(MyLinkedList<T> arr) {
        for (T obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
