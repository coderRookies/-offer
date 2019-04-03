package meettooffer.chapter5;

import javax.xml.crypto.Data;

public class InversePairs {
    public static void main(String[] args) {
        int[] array = { 2, 1, 3, 4, 5, 6};
        int num = inversePairs(array);
        System.out.println(num);
    }

    private static int inversePairs(int[] array) {
        if (array == null || array.length < 0) {
            return 0;
        }
        int copy[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = inversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private static int inversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(copy, array, start, start + length);
        int right = inversePairsCore(copy, array, start + length + 1, end);

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = array[j--];
            }
            for (; i >= start; --i) {
                copy[indexCopy--] = array[i];
            }
            for (; j >= start + length + 1; --j) {
                copy[indexCopy--] = array[j];
            }
        }
        return left + right + count;
    }
}
