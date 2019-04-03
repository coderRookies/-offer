package meettooffer.chapter6;

public class FindNumWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        findNumWithSum(array, 15);
    }

    private static void findNumWithSum(int[] array, int sum) {
        boolean find = false;
        if (array.length < 1) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int curr = array[start] + array[end];
            if (curr == sum) {
                System.out.println(array[start] + " + " + array[end]);
                break;
            } else if (curr > sum) {
                end--;
            } else {
                start++;
            }
        }
    }
}
