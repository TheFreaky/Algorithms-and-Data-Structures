package febrary9;

/**
 * Created by Максим on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        Queue queue = new Queue();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }

        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.size());

    }
}
