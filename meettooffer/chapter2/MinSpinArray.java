package meettooffer.chapter2;

import java.util.Arrays;
import java.util.Objects;

public class MinSpinArray {
    public static void main(String[] args) {
//        int[] array = {  1,1,1,4,-1,0,1,1 };
        int[] array = {  1,0,1 };
//        int[] array = {  4, 5, 6, 7, 1, 2,3 };
        System.out.println(min(array));
    }

    public static int min(int[] array) {
        Objects.requireNonNull(array);

        int start = 0, end = array.length - 1;
        if (array[start] < array[end] || array.length == 1) {   //  1,0,1
            return array[start];
        }
        int middle = (start + end) >>> 1;
        if (array[middle] >= array[start]) {
            return min(Arrays.copyOfRange(array, middle + 1, array.length));
        } else {
            return min(Arrays.copyOfRange(array, start, middle + 1));
        }
    }
}
