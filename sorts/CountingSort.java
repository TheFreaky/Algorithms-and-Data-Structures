package sorts;

/**
 * Created by Максим on 30.03.2017.
 */
public class CountingSort {
    public void sort(int[] arr, int start, int end) {
        int length = end - start + 1;
        int[] range = new int[length];

        for (int element : arr) {
            int index = element - start;
            range[index] += 1;
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < range.length; i++) {
            if (range[i] > 0) {
                System.out.print(start + i + " ");
                range[i] -= 1;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12312, 12, 321, 4324, 1, 6455, 345, 73, 5345, 13, 123, 52214, 13, 123, 123, 12};
        new CountingSort().sort(a, 1, 52214);
    }
}