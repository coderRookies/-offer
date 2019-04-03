package meettooffer.chapter5;

import java.util.Arrays;

public class MaxSubSequence {
    public static void main(String[] args) {
        String sequence = "asdoijadjiasd";
        int length = maxSubSequence(sequence.toCharArray());
        System.out.println(length);
    }

    private static int maxSubSequence(char[] sequence) {
        int currentLength = 0;
        int maxLength = 0;
        int[] position = new int[26];
        Arrays.fill(position, -1);
        for (int i = 0; i < sequence.length; i++) {
            int prevIndex = position[sequence[i] - 'a'];
            if (prevIndex < 0 || i - prevIndex > currentLength) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = i - prevIndex;
            }
            position[sequence[i] - 'a'] = i;
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }
}
