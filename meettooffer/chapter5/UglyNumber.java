package meettooffer.chapter5;

public class UglyNumber {
    public static void main(String[] args) {
        int result = getUglyNumber(100);
        System.out.println(result);
    }

    private static int getUglyNumber(int num) {
        if (num <= 0) {
            return 0;
        }
        int[] pUglyNumbers = new int[num];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        while (nextUglyIndex < num) {
            int min = minOfThree(pUglyNumbers[multiply2] * 2, pUglyNumbers[multiply3] * 3, pUglyNumbers[multiply5] * 5);
            pUglyNumbers[nextUglyIndex] = min;
            while (pUglyNumbers[multiply2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                ++multiply2;
            }
            while (pUglyNumbers[multiply3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                ++multiply3;
            }
            while (pUglyNumbers[multiply5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                ++multiply5;
            }
            nextUglyIndex++;
        }
        int ugly = pUglyNumbers[nextUglyIndex - 1];
        return ugly;
    }

    private static int minOfThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
