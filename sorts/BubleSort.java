package sorts;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 94, 1, 9, 1, 98, 9, 198, -1, 981, 6, -50};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    static int[] sortArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }

        return arr;
    }
}
