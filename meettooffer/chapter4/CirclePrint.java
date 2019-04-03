package meettooffer.chapter4;

import java.util.StringJoiner;

public class CirclePrint {
    public static void main(String[] args) {
        int[][] matrix= new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + 1) * j; 
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            StringJoiner sj = new StringJoiner(" ", "", "\n"); 
            for (int j = 0; j < matrix[i].length; j++) {
                sj.add(Integer.toString(matrix[i][j]));
            }
            System.out.println(sj.toString());
        }
        circlePrint(matrix);
    }

    private static void circlePrint(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int start = 0;
        int col = matrix.length;
        int row = matrix[0].length;
        StringJoiner resultJoiner = new StringJoiner(" ");
        while (col > start * 2 && row > start * 2) {
            String result = printMatrix(matrix, col, row, start);
            resultJoiner.add(result);
            start ++;
        }
        System.out.println(resultJoiner.toString());
    }

    private static String printMatrix(int[][] matrix, int col, int row, int start) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        StringJoiner sj = new StringJoiner(" ");
        for (int i = start; i <= endX; i++) {
            sj.add(Integer.toString(matrix[start][i]));
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                sj.add(Integer.toString(matrix[i][endX]));
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                sj.add(Integer.toString(matrix[endY][i]));
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                sj.add(Integer.toString(matrix[i][start]));
            }
        }
        return sj.toString();
    }
}
