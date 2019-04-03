package meettooffer.chapter5;

import java.util.Arrays;

public class CountOne {
    public static void main(String[] args) {
        int digit = 199; //
        int one = computeOne(digit);
        System.out.println(one);
    }
    private static int computeOne(int n) {
      if (n <= 0) {
          return 0;
      }
      char[] array = Integer.toString(n).toCharArray();
      return compute(array);
    }
    private static int compute(char[] array) {
        if (array == null) {
            return 0;
        }
        int first = array[0] - '0';
        int length = array.length;
        if (length == 1) {
            return first == 0 ? 0 : 1;
        }
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
//            numFirstDigit = Integer.parseInt(new String(Arrays.copyOfRange(array, 1, length))) + 1;
            numFirstDigit = Integer.parseInt(new String(array, 1, length - 1)) + 1;
        }
        int numOtherDigit = first * (length - 1) * powerBase10(length - 1 - 1);
        int numRecursive = compute(Arrays.copyOfRange(array, 1, length));
        return numFirstDigit + numOtherDigit + numRecursive;
    }
    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}
