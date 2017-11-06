package sorts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Максим on 01.05.2017.
 */
public class LSDRadixSort {
    private static final int DIGIT_COUNT = 10;

    public static int[] sort(int[] arr) {
        List<Integer> numbers;
        int[] limits = getDigitCount(arr);
        arr = normalizeArray(arr, limits[1]);

        int digitDivider = 1;
        for (int digit = 1; digit <= limits[0]; digit++) {
            List<Queue<Integer>> basket = new ArrayList<>(DIGIT_COUNT);

            for (int i = 0; i < DIGIT_COUNT; i++) {
                basket.add(null);
            }

            for (int value : arr) {
                int num = value / digitDivider % DIGIT_COUNT;

                if (basket.get(num) == null) {
                    basket.set(num, new LinkedList<>());
                }
                basket.get(num).add(value);
            }

            numbers = new ArrayList<>();
            for (int i = 0; i < DIGIT_COUNT; i++) {
                if (basket.get(i) == null) continue;

                while (basket.get(i).size() > 0) {
                    int number = basket.get(i).poll();
                    numbers.add(number);
                }
            }

            arr = numbers.stream().mapToInt(i -> i).toArray();

            digitDivider *= DIGIT_COUNT;
        }

        arr = normalizeArray(arr, -limits[1]);

        return arr;
    }

    private static int[] normalizeArray(int[] arr, int delta) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= delta;
        }

        return arr;
    }

    private static int[] getDigitCount(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int delta = String.valueOf(max - min).length();

        return new int[]{delta, min};
    }

}