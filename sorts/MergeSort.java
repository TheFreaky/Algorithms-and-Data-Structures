package sorts;

import java.util.Arrays;

/**
 * Created by Максим on 01.12.2016.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 94, 1, 9, 1, 98, 9, 198, -1, 981, 6, -50};
        int[] arr2 = {-46, 54, 518, 541, 0, 1, 3, 64, 13};
//        Arrays.sort(arr);
//        Arrays.sort(arr2);
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr, int[] arr2) {
        int[] result = new int[arr.length + arr2.length];
        int indexFrt = 0;
        int indexScd = 0;
        for (int i = 0; i < result.length; i++) {
            if (arr[indexFrt] < arr2[indexScd]) {
                result[i] = arr[indexFrt];
                indexFrt++;
            } else {
                result[i] = arr2[indexScd];
                indexScd++;
            }
            if (indexFrt >= arr.length) {
                System.arraycopy(arr2, indexScd, result, i + 1, arr2.length - indexScd);
                break;
            } else if (indexScd >= arr2.length) {
                System.arraycopy(arr, indexFrt, result, i + 1, arr.length - indexFrt);
                break;
            }
        }

        return result;
    }

    static void sort(int[] arr, int start, int end) {
        if (start + 1 >= end) return;

        int mid = (start + end) >>> 1;
        sort(arr, start, mid);
        sort(arr, mid, end);

        int size = end - start;
        int[] arr2 = new int[size];

        int i = start;
        int j = mid;
        for (int k = 0; k < size; k++) {
            if (j >= end || i < mid) {
                if (arr[i] < arr[j]) {
                    arr2[k] = arr[i++];
                }
            } else {
                arr2[k] = arr[j++];
            }
        }
        System.arraycopy(arr2, 0, arr, start, size);
    }
}
