package meettooffer.chapter6;

public class WithoutOperate {
    public static void main(String[] args) {
        int result = add(15, 7);
        System.out.println(result);
    }

    private static int add(int i, int i1) {
        int sum, carry;
        do {
            sum = i ^ i1;
            carry = (i & i1) << 1;
            i = sum;
            i1 = carry;
        } while (i1 != 0);
        return i;
    }
}

