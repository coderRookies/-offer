package meettooffer.chapter2;

public class DuplicationInArray {
    // length = n, range 0 - n-1
    public static void duplicate(int[] numbers) {
        if (numbers == null) {
            return;
        }
        for (int i = 0, length = numbers.length; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] >= length) {
                    return;
                }
                if (numbers[numbers[i]] == numbers[i]) {
                    System.out.println(numbers[i]);
                    break;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[] { 2, 3, 1, 0, 2, 5, 3 };
        duplicate(arrays);
    }
}
