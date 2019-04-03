package meettooffer.chapter3;

public class IsNumeric {
    public static final int FALSE = -1;
    public static void main(String[] args) {
        char[] strings = {'e','2'};
        boolean isNumeric = isNumeric(strings);
        System.out.println(isNumeric);
    }

    private static boolean isNumeric(char[] strings) {
        if (strings == null) {
            return false;
        }
        int numeric = scanInteger(strings, 0);
        if (numeric == FALSE) {
            return false;
        }
        if (numeric < strings.length && strings[numeric] == '.') {
            numeric ++;
            numeric = scanUnsignedInteger(strings, numeric);
            if (numeric == FALSE) {
                return false;
            }
            if (numeric < strings.length && (strings[numeric] == 'e' || strings[numeric] == 'E')) {
                numeric ++;
                numeric = scanInteger(strings, numeric);
            }
        }
        
        return numeric == strings.length;
    }

    private static int scanInteger(char[] strings, int index) {
        if (index < strings.length && (strings[index] == '+' || strings[index] == '-')) {
            index ++;
        }
            
        return scanUnsignedInteger(strings, index);
    }

    private static int scanUnsignedInteger(char[] strings, int index) {
        int before = index;
        while (index < strings.length && strings[index] >= '0' && strings[index] <= '9') {
            index ++;
        }
        return index > before ? index : FALSE;
    }
}
