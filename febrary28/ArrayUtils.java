package febrary28;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Максим on 21.02.2017.
 */
public class ArrayUtils {
    public static <T> void fill(T[] arr, T obj) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = obj;
        }
    }

    public static <T> void fill(T[] arr, Runnable f) {
        f.run();
    }

    public static <T> T[] merge(T[]... arrs) {
        ArrayList<T> list = new ArrayList<T>();
        for (T[] arr : arrs) {
            list.addAll(Arrays.asList(arr));
        }
        return list.toArray(arrs[0]);
    }

    public static void main(String[] args) {
//        Integer[] arr = new Integer[10];
//        ArrayUtils.fill(arr, 0);
//        System.out.println(Arrays.toString(arr));
//
//        ArrayUtils.fill(arr, () -> {
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] += i;
//            }
//        });
//
//        System.out.println(Arrays.toString(arr));

        Integer[] arr = merge(
                new Integer[]{1,6651,648,698,198,49816,8,61981,6,},
                new Integer[]{94,9916,91,94,8,464,984,64984,64798,46,4984,1},
                new Integer[]{94,94913,31,916,4651,1,65},
                new Integer[]{91321,98852,31,163,1651,16,315});

        System.out.println(Arrays.toString(arr));
    }
}
