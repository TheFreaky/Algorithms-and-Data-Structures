package sorts;

import java.util.Arrays;

/**
 * Created by Максим on 28.11.2016.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 94, 1, 9, 1, 98, 9, 198, -1, 981, 6, -50};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int swap = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = swap;
            }
        }

        return arr;
    }
}