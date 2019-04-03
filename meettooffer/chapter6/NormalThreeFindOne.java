package meettooffer.chapter6;

public class NormalThreeFindOne {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 2, 3};
        int num = findNumber(array);
        System.out.println(num);
    }

    private static int findNumber(int[] array) {
        if (array == null || array.length <= 0) {
            throw new IllegalArgumentException("invalid input");
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < array.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = array[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
}
