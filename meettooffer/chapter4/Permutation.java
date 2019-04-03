package meettooffer.chapter4;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Permutation {
    public static void main(String[] args) {
        char[] cs = { 'a', 'b', 'c' };
        // char[] cs = {'h','e','l','l','o','w','o','r','l','d'};
        permutation(cs);
    }

    private static void permutation(char[] cs) {
        if (cs == null) {
            return;
        }
        permutation2(cs, 0);
    }

    private static void permutation2(char[] cs, int index) {
        while (index < cs.length) {
            for (int i = index; i < cs.length; i++) {
                char ch = cs[i];
                cs[i] = cs[index];
                cs[index] = ch;
                printOffset(cs, index);
                ch = cs[i];
                cs[i] = cs[index];
                cs[index] = ch;
            }
            index++;
        }

    }

    private static void printOffset(char[] cs, int index) {
        System.out.println(Arrays.copyOfRange(cs, 0, index + 1));
    }

    private static void permutation(char[] cs, int index) {
        if (index == cs.length - 1) {
            System.out.println(cs);
        } else {
            for (int i = index; i < cs.length; i++) {
                char ch = cs[i];
                cs[i] = cs[index];
                cs[index] = ch;
                permutation(cs, index + 1);
                ch = cs[i];
                cs[i] = cs[index];
                cs[index] = ch;
            }
        }
    }
}
