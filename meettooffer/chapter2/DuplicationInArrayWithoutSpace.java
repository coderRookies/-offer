package meettooffer.chapter2;


public class DuplicationInArrayWithoutSpace {
    public static int getDuplication(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int start = 1;
        int end = numbers.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int i = 0, length = numbers.length; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 1, 5, 4, 3, 2, 6, 7 };
        System.out.println(getDuplication(numbers));
    }
}
