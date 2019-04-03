package meettooffer.chapter2;

public class CutRope {
    public static void main(String[] args) {
        int length = 11;
        int result = maxRopeMultiply(length);
        int result2 = maxRopeMultiply_greedy(length);
        System.out.println(result);
        System.out.println(result2);
    }

    private static int maxRopeMultiply_greedy(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timesOfThree = length / 3;
        if (length - timesOfThree * 3 == 1) {
            timesOfThree -= 1;
        }
        int timesOfTwo = (length - timesOfThree * 3) / 2;
        return (int) (Math.pow(3, timesOfThree)) * (int) (Math.pow(2, timesOfTwo));
    }

    private static int maxRopeMultiply(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] results = new int[length + 1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;
        
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int result = results[j] * results[i - j];
                if (max < result) {
                    max = result;
                    results[i] = max;
                }
            }
        }
        
        max = results[length];
        return max;
    }
}
