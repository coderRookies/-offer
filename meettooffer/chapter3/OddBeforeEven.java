package meettooffer.chapter3;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class OddBeforeEven {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        oddBeforeEven(array);
        oddBeforeEven(array, p -> p % 3 == 0);
    }

    private static void oddBeforeEven(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("");
        }
        int start = 0, end = array.length - 1;
        while (end > start) {
            while (array[start] % 2 == 0) {
                start ++;
            }
            while (array[end] % 2 == 1) {
                end --;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static void oddBeforeEven(int[] array, IntPredicate predicate) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("");
        }
        int start = 0, end = array.length - 1;
        while (end > start) {
            while (predicate.test(array[start])) {
                start ++;
            }
            while (!predicate.test(array[end])) {
                end --;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
