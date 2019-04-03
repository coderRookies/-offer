package meettooffer.chapter2;

public class CountBinaryOne {
    
    public static void main(String[] args) {
        int num = 0x8000000;
        int result = countOne1(num);
        System.out.println(result);
        result = countOne2(num);
        System.out.println(result);
        result = countOne3(num);
        System.out.println(result);
        System.out.println(countDiff(0, -1));
    }

    private static int countOne1(int num) {
        int count = 0;
        int n = 1;
        while (num != 0) {
            if ((num & n) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }
    
    private static int countOne2(int num) {
        int count = 0;
        int n = 1;
        if (num < 0) {
            count = 1;
        }
        while (n > 0) {
            if ((num & n) != 0) {
                count++;
            }
            n = n << 1;
        }
        return count;
    }

    private static int countOne3(int num) {
        int count = 0;
        while (num != 0) {
            count ++;
            num = (num - 1) & num;
        }
        return count;
    }
    private static int countDiff(int a, int b) {
        return countOne3(a ^ b);
    }
}
