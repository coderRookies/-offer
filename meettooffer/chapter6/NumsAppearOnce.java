package meettooffer.chapter6;


import java.util.Arrays;

public class NumsAppearOnce {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4};
        int[] num = findNumsAppearOnce(array);
        System.out.println(Arrays.toString(num));
    }

    private static int[] findNumsAppearOnce(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }
        int resultXOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultXOR ^= array[i];
        }
        int result[] = {0, 0};
        int index = findFirstBitsIs1(resultXOR);
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {
                result[0] ^= array[i];
            } else {
                result[1] ^= array[i];
            }
        }
        return result;
    }

    private static boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

    private static int findFirstBitsIs1(int resultXOR) {
        int indexBit = 0;
        while (((resultXOR & 1) == 0) && (indexBit < 32)) {
            resultXOR = resultXOR >> 1;
            ++indexBit;
        }
        return indexBit;
    }
}
