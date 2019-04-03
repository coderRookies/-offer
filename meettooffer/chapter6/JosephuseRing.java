package meettooffer.chapter6;

public class JosephuseRing {
    public static void main(String[] args) {
        int length = 3, step = 1;
        int survivor = josephuseRing(length, step);
        System.out.println(survivor);
    }

    private static int josephuseRing(int length, int step) {
        if (length < 1 || step < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= length; i++) {
            last = (last + step) % i;
        }
        return last;
    }
}
