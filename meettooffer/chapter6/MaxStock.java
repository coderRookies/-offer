package meettooffer.chapter6;

public class MaxStock {
    public static void main(String[] args) {
        int[] stockPrice = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int benefit = sellStock(stockPrice);
        System.out.println(benefit);
    }

    private static int sellStock(int[] stockPrice) {
        if (stockPrice == null || stockPrice.length < 2) {
            return 0;
        }
        int min = stockPrice[0];
        int maxDiff = stockPrice[1] - min;
        for (int i = 2; i < stockPrice.length; i++) {
            if (stockPrice[i - 1] < min) {
                min = stockPrice[i - 1];
            }
            int currDiff = stockPrice[i] - min;
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
        }
        return maxDiff;
    }
}
