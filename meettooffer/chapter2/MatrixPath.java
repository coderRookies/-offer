package meettooffer.chapter2;

public class MatrixPath {
    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        char[] target = {'b', 'f', 'c', 'c', 'g', 's','h'};
        boolean hasPath = hasPath(matrix, matrix.length, matrix[0].length, target);
        System.out.println(hasPath);
    }
    public static boolean hasPath(char[][] matrix, int rows, int cols, char[] target) {
        if (matrix == null) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, target, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, char[] target,
            int pathLength, boolean[][] visited) {
        
        if (pathLength == target.length) {
            return true;
        }
        
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == target[pathLength] && !visited[row][col]) {
            pathLength ++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, target, pathLength, visited)    // 左
                    || hasPathCore(matrix, rows, cols, row - 1, col, target, pathLength, visited)   // 上
                    || hasPathCore(matrix, rows, cols, row, col + 1, target, pathLength, visited)   // 右
                    || hasPathCore(matrix, rows, cols, row + 1, col, target, pathLength, visited);// 下
            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        
        return hasPath;
    }
}
