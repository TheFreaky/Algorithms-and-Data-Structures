package april27;

import java.util.Arrays;

public class BinaryNumber {
    private boolean[] bits;

    public BinaryNumber() {
        bits = new boolean[1];
    }

    public BinaryNumber(boolean[] bits) {
        this.bits = bits;
    }

    public BinaryNumber(BinaryNumber number) {
        this.bits = number.bits;
    }

    public BinaryNumber(int number) {
        String string = Integer.toBinaryString(number);

        bits = new boolean[string.length()];

        char[] bitsChar = string.toCharArray();
        for (int i = 0; i < bitsChar.length; i++) {
            if (bitsChar[i] == '1') bits[i] = true;
        }
    }

    public BinaryNumber multiplyKaratsuba(BinaryNumber number) {
        BinaryNumber[] numberA = divideArray(bits);
        BinaryNumber[] numberB = divideArray(number.bits);
        int length = number.bits.length / 2;

        int baseM = 1;
        for (int i = 0; i < length; i++) baseM *= 2;
        int base2M = baseM * baseM;

        BinaryNumber A0B0 = numberA[0].multiply(numberB[0]);
        BinaryNumber A1B1 = numberA[1].multiply(numberB[1]);
        BinaryNumber result = A0B0
                .add(
                        numberA[0].add(numberA[1])
                                .multiply(numberB[0]
                                        .add(numberB[1]))
                                .substract(A0B0)
                                .substract(A1B1)
                                .multiply(new BinaryNumber(baseM))
                ).add(
                        A1B1.multiply(new BinaryNumber(base2M))
                );

        return result;
    }

    public BinaryNumber add(BinaryNumber number) {
        int maxLength = Math.max(bits.length, number.bits.length);
        boolean[] result = new boolean[maxLength + 1];
        boolean[] arr = null;

        if (bits.length != maxLength) {
            System.arraycopy(bits, 0, result, maxLength - bits.length + 1, bits.length);
            arr = number.bits;
        } else {
            System.arraycopy(number.bits, 0, result, maxLength - number.bits.length + 1, number.bits.length);
            arr = bits;
        }

        boolean one;

        one = arr[arr.length - 1] && result[result.length - 1];
        result[result.length - 1] = arr[arr.length - 1] ^ result[result.length - 1];

        for (int i = maxLength - 3; i >= 0; i--) {
            result[i + 1] = arr[i] ^ result[i + 1] ^ one;
            one = arr[i] && result[i + 1] && one;
        }
        return new BinaryNumber(result);
    }

    public BinaryNumber substract(BinaryNumber number) {
        int maxLength = Math.max(bits.length, number.bits.length);
        boolean[] result = new boolean[maxLength];
        boolean[] arr;

        if (bits.length != maxLength) {
            System.arraycopy(bits, 0, result, maxLength - bits.length + 1, bits.length);
            arr = number.bits;
        } else {
            System.arraycopy(number.bits, 0, result, maxLength - number.bits.length + 1, number.bits.length);
            arr = bits;
        }

        for (int i = result.length - 1; i > 0; i--) {
            if (!result[i] && !arr[i] || result[i] && arr[i]) {
                result[i] = false;
            } else if (result[i] && !arr[i] || !result[i] && result[i - 1] && arr[i]) {
                result[i] = true;
            }
        }

        return new BinaryNumber(result);
    }

    public BinaryNumber multiply(BinaryNumber number) {
        BinaryNumber result = new BinaryNumber();
        BinaryNumber temp = new BinaryNumber(number);

        for (int i = bits.length - 1; i > 0; i--) {
            if (bits[i]) {
                result.add(temp);
            }
            temp = temp.leftShift();
        }

        return result;
    }

    private BinaryNumber leftShift() {
        boolean[] result = new boolean[bits.length + 1];
        System.arraycopy(bits, 0, result, 0, bits.length);
        return new BinaryNumber(result);
    }

    private BinaryNumber[] divideArray(boolean[] arr) {
        int length = arr.length / 2;
        boolean[] part1;
        boolean[] part2 = new boolean[length];

        if (arr.length % 2 == 0) {
            part1 = new boolean[length];
            System.arraycopy(arr, length, part2, 0, length);
        } else {
            part1 = new boolean[length + 1];
            System.arraycopy(arr, length + 1, part2, 0, length);
        }

        System.arraycopy(arr, 0, part1, 0, part1.length);
        return new BinaryNumber[]{new BinaryNumber(part2), new BinaryNumber(part1)};
    }

    @Override
    public String toString() {
        int sum = 0;
        int factor = 1;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i]) sum += factor;
            factor = factor << 1;
        }
        return String.valueOf(sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryNumber that = (BinaryNumber) o;

        return Arrays.equals(bits, that.bits);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bits);
    }
}
