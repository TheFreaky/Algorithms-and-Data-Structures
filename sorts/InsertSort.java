package sorts;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 94, 1, 9, 1, 98, 9, 198, -1, 981, 6, -50};
        System.out.println(Arrays.toString(sortArray2(arr)));
    }

    public static int[] sortArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i];
            int prevIndex = i - 1;
            while (prevIndex >= 0 && arr[prevIndex] > currElem) {
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex--;
            }
            arr[prevIndex + 1] = currElem;
        }
        return arr;
    }

    public static int[] sortArray2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i];
            int index = Arrays.binarySearch(arr, 0, i, currElem);
            if (index < 0) index = (index + 1) * -1;

            System.arraycopy(arr, index, arr, index + 1, i - index);
            arr[index] = currElem;
        }
        return arr;
    }


}