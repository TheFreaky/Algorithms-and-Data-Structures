package april20;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private Matrix() {
    }

    public static int[][] multiply(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length) {
            throw new InvalidParameterException("Matrix aren't the same size!");
        }

        int length = arr1.length;
        if (length == 8) {
            return multiplyLoop(arr1, arr2);
        }

        List<int[][]> listA = split(arr1);
        int[][] a11 = listA.get(0);
        int[][] a12 = listA.get(1);
        int[][] a21 = listA.get(2);
        int[][] a22 = listA.get(3);

        List<int[][]> listB = split(arr2);
        int[][] b11 = listB.get(0);
        int[][] b12 = listB.get(1);
        int[][] b21 = listB.get(2);
        int[][] b22 = listB.get(3);

        int[][] p1 = multiply(sum(a11, a22, 1), sum(b11, b22, 1));
        int[][] p2 = multiply(sum(a21, a22, 1), b11);
        int[][] p3 = multiply(a11, sum(b12, b22, -1));
        int[][] p4 = multiply(a22, sum(b21, b11, -1));
        int[][] p5 = multiply(sum(a11, a12, 1), b22);
        int[][] p6 = multiply(sum(a21, a11, -1), sum(b11, b12, 1));
        int[][] p7 = multiply(sum(a12, a22, -1), sum(b21, b22, 1));

        int[][] c11 = sum(sum(p1, p4, 1), sum(p7, p5, -1), 1);
        int[][] c12 = sum(p3, p5, 1);
        int[][] c21 = sum(p2, p4, 1);
        int[][] c22 = sum(sum(p3, p6, 1), sum(p1, p2, -1), 1);

        return concat(c11, c12, c21, c22);
    }

    private static int[][] concat(int[][] a11, int[][] a12, int[][] a21, int[][] a22) {
        int length = a11.length;
        int[][] arr = new int[length * 2][length * 2];
        for (int i = 0; i < length; i++) {
            System.arraycopy(a11[i], 0, arr[i], 0, length);
            System.arraycopy(a12[i], 0, arr[i], length, length);
            System.arraycopy(a21[i], 0, arr[i + length], 0, length);
            System.arraycopy(a22[i], 0, arr[i + length], length, length);
        }
        return arr;
    }

    private static List<int[][]> split(int[][] arr) {
        int length = arr.length;
        int halfLength = length / 2;
        List<int[][]> list = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {
            list.add(new int[halfLength][halfLength]);
        }

        for (int i = 0; i < length; i++) {
            System.arraycopy(arr[i], 0, list.get(0)[i], 0, length);
            System.arraycopy(arr[i], length, list.get(1)[i], 0, length);
            System.arraycopy(arr[i + length], 0, list.get(2)[i], 0, length);
            System.arraycopy(arr[i + length], length, list.get(3)[i], 0, length);
        }

        return list;
    }

    private static int[][] sum(int[][] arr1, int[][] arr2, int multiplyer) {
        int length = arr1.length;
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j] * multiplyer;
            }
        }
        return arr;
    }

    private static int[][] multiplyLoop(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                arr[i][j] = 0;
                for (int k = 0; k < arr1.length; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }
}
