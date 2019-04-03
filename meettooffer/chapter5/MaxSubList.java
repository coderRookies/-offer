package meettooffer.chapter5;

public class MaxSubList {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,-20,2,3,12};
        int max = maxSubList(a);
        System.out.println(max);
    }

    private static int maxSubList(int[] a) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < a.length; i++) {
            current += a[i];
            if (current > max) {
                max = current;
            } else if (current < 0) {
                current = 0;
            }
        }
        return max;
    }
}
