package meettooffer.chapter6;

import sun.security.util.Length;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,6,7};
        int number = getMissingNumber(array);
        System.out.println(number);
    }

    private static int getMissingNumber(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (right + left) >>> 1;
            if (array[middle] != middle) {
                if (middle == 0 || array[middle - 1] == middle - 1) {
                    return  middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left == array.length) {
            return array.length;
        }
        return -1;
    }
}
