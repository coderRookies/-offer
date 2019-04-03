package meettooffer.chapter4;

public class VerifySequenceOfBST {
    public static void main(String[] args) {
        boolean isBST = false;
//        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence = {7, 4, 6, 5};
//        int[] sequence = {1, 2, 3, 4};
        isBST = verifySequenceOfBST(sequence, 0, sequence.length - 1);
        System.out.println(isBST);
    }

    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (sequence == null) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int less = start, bigger = end - 1;
        while (less <= end && sequence[less] < root) {
            less++;
        }
        while (bigger >= start && sequence[bigger] > root) {
            bigger--;
        }
        if (less <= bigger) {
            return false;
        }
        return verifySequenceOfBST(sequence, start, bigger) && verifySequenceOfBST(sequence, less, end - 1);
    }
}
