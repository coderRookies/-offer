package meettooffer.chapter5;

public class MaxValuePath {
    public static void main(String[] args) {
        int[][] gift = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 16, 5 } };

        int max = maxValue(gift);
        System.out.println(max);
        max = maxValue2(gift);
        System.out.println(max);
    }

    private static int maxValue(int[][] gift) {
        if (gift == null || gift.length <= 0 || gift[0].length <= 0) {
            return 0;
        }
        int rows = gift.length, cols = gift[0].length;
        int[][] value = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = value[i - 1][j];
                }
                if (j > 0) {
                    left = value[i][j - 1];
                }
                value[i][j] = Math.max(left, up) + gift[i][j];
            }
        }
        return value[rows - 1][cols - 1];
    }

    private static int maxValue2(int[][] gift) {
        if (gift == null || gift.length <= 0 || gift[0].length <= 0) {
            return 0;
        }
        int rows = gift.length, cols = gift[0].length;
        int[] value = new int[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = value[j];
                }
                if (j > 0) {
                    left = value[j - 1];
                }
                value[j] = Math.max(left, up) + gift[i][j];
            }
        }
        return value[cols - 1];
    }
}
