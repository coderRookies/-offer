package meettooffer.chapter3;

public class PrintDigit {
    public static void main(String[] args) {
        int max = 8;
         printDigit(max);
    }

    private static void printDigit(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("input can't less than 1");
        }
        char[] base = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] charbuffer = new char[max];
        for (int i = 0; i < charbuffer.length; i++) {
            charbuffer[i] = base[0];
        }
        while (increment(charbuffer, charbuffer.length - 1, base)) {
            print(charbuffer);
        }

    }

    private static boolean increment(char[] charbuffer, int index, char[] base) {
        charbuffer[index] = base[(charbuffer[index] - 0x2F) % 10];
        if (index == 0 && charbuffer[index] == '0') {
            return false;
        }
        if (charbuffer[index] == '0') {
            return increment(charbuffer, index - 1, base);
        }
        return true;
    }

    private static void print(char[] charbuffer) {
        int index = 0;
        while (charbuffer[index] == '0' && index != charbuffer.length - 1) {
            index++;
        }
        System.out.println(new String(charbuffer, index, charbuffer.length - index));
    }
}
