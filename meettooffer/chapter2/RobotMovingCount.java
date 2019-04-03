package meettooffer.chapter2;


public class RobotMovingCount {
    public static void main(String[] args) {
        int threshold = 1;
        int m = 10, n = 9;
        int count = movingCount(threshold, m, n);
        System.out.println(count);
    }

    private static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }
    private static int movingCountCore(int threshold, int rows, int cols, int x, int y, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, x, y, visited)) {
            visited[x][y] = true;
            count = 1 + movingCountCore(threshold, rows, cols, x - 1, y, visited) + // 上
                    movingCountCore(threshold, rows, cols, x, y - 1, visited) +     // 左
                    movingCountCore(threshold, rows, cols, x + 1, y, visited) +     // 下
                    movingCountCore(threshold, rows, cols, x, y + 1, visited);      // 右
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int x, int y, boolean[][] visited) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && computeThreshold(threshold, x, y) && !visited[x][y]) {
            return true;
        }
        return false;
    }

    private static boolean computeThreshold(int threshold, int x, int y) {
        int result = 0;
        while (x >= 1 || y >= 1) {
            result += x % 10;
            result += y % 10;
            x /= 10;
            y /= 10;
        }
        return result <= threshold;
    }
}
