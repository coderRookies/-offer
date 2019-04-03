package meettooffer.chapter5;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class FirstNotRepeat {
    public static void main(String[] args) {
//        String sequence = "aisdoiijaoifhoiioasdoiioqz";
        String sequence = "acb";
        char fnr = firstNotRepeat(sequence);
        System.out.println(fnr);
        firstNotRepeatAdvanced(30);
    }

    private static char firstNotRepeat(String sequence) {
        int[] table = new int[256];
        Arrays.fill(table, 0);
        for (char c : sequence.toCharArray()) {
            table[c] ++;
        }
        for (int i = 0; i < 256; i++) {
            if (table[i] == 1) {
                return (char) i;
            }
        }
        return 0;
    }
    // 利用生成器生成随机字符，然后打印出现一次的字符
    private static char firstNotRepeatAdvanced(int limit) {
        int[] table = new int[26];
        Arrays.fill(table, 0);
        Supplier<Integer> si = new Supplier<Integer>() {
            private Random seed = new Random();
            @Override
            public Integer get() {
                return seed.nextInt(26);
            }
        };
        int count = 0;
        while (count < limit) {
            Integer integer = si.get();
            System.out.println(integer);
            table[integer]++;
            for (int i = 0; i < table.length; i++) {
                if (table[i] == 1) {
                    System.out.println((char) (i + 97));
                    break;
                }
            }
            count++;
        }
        return 0;
    }
}
