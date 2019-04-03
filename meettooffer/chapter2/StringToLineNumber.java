package meettooffer.chapter2;

import java.util.Scanner;


public class StringToLineNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int line = toLineNumber(string.toLowerCase());
        System.out.println(line);
        sc.close();
    }

    private static int toLineNumber(String string) {
        int result = 0;
        char[] chars = string.toCharArray();
        for (int i = 0, length = chars.length; i < length; i++) {
            result *= 26;
            result += getWeight(chars[i]);
        }
        return result;
    }

    private static int getWeight(char c) {
        int weight = 0;
        switch (c) {
        case 'a': weight = 1; break;
        case 'b': weight = 2; break;
        case 'c': weight = 3; break;
        case 'd': weight = 4; break;
        case 'e': weight = 5; break;
        case 'f': weight = 6; break;
        case 'g': weight = 7; break;
        case 'h': weight = 8; break;
        case 'i': weight = 9; break;
        case 'j': weight = 10; break;
        case 'k': weight = 11; break;
        case 'l': weight = 12; break;
        case 'm': weight = 13; break;
        case 'n': weight = 14; break;
        case 'o': weight = 15; break;
        case 'p': weight = 16; break;
        case 'q': weight = 17; break;
        case 'r': weight = 18; break;
        case 's': weight = 19; break;
        case 't': weight = 20; break;
        case 'u': weight = 21; break;
        case 'v': weight = 22; break;
        case 'w': weight = 23; break;
        case 'x': weight = 24; break;
        case 'y': weight = 25; break;
        case 'z': weight = 26; break;

        default: break;
        }
        return weight;
    }
}
