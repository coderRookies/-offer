package meettooffer.chapter6;

public class LeftRotate {
    public static void main(String[] args) {
        String string = "helloworld";
        int offset = 4;
        String result = leftRotate(string, offset);
        System.out.println(result);
    }

    private static String leftRotate(String string, int offset) {
        String sub1 = string.substring(0, offset + 1);
        String sub2 = string.substring(offset + 1);
        return sub2 + sub1;
    }
}
