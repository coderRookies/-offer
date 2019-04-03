package meettooffer.chapter6;

import java.util.Objects;

public class NumberSameAsIndex {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 3, 5, 7, 9};
        int number = getNumberSameAsIndex(array);
        System.out.println(number);
    }

    private static int getNumberSameAsIndex(int[] array) {
        Objects.requireNonNull(array);
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int middle = (end + start) >>> 1;
            if (array[middle] == middle) {
                return  middle;
            } else if (array[middle] < middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
