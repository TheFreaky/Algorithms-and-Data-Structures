package may18;

/**
 * Created by Максим on 18.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Treap treap = new Treap();

        treap.add(5);
        treap.add(12);
        treap.add(18);

        treap.remove(5);
        treap.remove(12);
    }
}
