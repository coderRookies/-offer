package meettooffer.chapter6;

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        String string = "i am a student.";
        String result = reverseString(string);
        System.out.println(result);
    }

    private static String reverseString(String string) {
        Objects.requireNonNull(string);
        String[] ss = string.split(" ");
        ArrayList<String> a = new ArrayList(Arrays.asList(ss));
        Collections.reverse(a);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String s : a) {
            stringJoiner.add(s);
        }
        return  stringJoiner.toString();
    }
}
