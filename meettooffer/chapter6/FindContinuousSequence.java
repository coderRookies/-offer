package meettooffer.chapter6;

import java.util.StringJoiner;

public class FindContinuousSequence {
    public static void main(String[] args) {
        int sum = 15;
        findContinuousSequence(sum);
    }

    private static void findContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
//        int middle =
        int curr = small + big;
        while (small < big) {
            if (curr == sum) {
                printSequence(small, big);
            }
            while (curr > sum) {
                curr -= small;
                small ++;
                if (curr == sum && small < big) {
                    printSequence(small, big);
                }
            }
            big++;
            curr += big;
        }
    }

    private static void printSequence(int small, int big) {
        StringJoiner stringJoiner = new StringJoiner(" ", "{", "}");
        for (int i = small; i <= big; i++) {
            stringJoiner.add(String.valueOf(i));
        }
        System.out.println(stringJoiner.toString());
    }
}
