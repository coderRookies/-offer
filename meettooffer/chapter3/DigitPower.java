package meettooffer.chapter3;

public class DigitPower {
    public static void main(String[] args) {
        double base = 10;
        int exp = 2;
        double result = power1(base, exp);
        System.out.println(result);
        result = power2(base, exp);
        System.out.println(result);
    }
    private static double power2(double base, int exp) {
        if (base == 0) {
            return 0;
        }
        if (exp == 0) {
            return 1;
        }
        int absExp = Math.abs(exp);
        double result = powerExponent2(base, absExp);
        if (exp < 0) {
            result = 1/result;
        }
        return result;
    }
    private static double powerExponent2(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        double result = powerExponent2(base, exp >> 1);
        result *= result;
        if ((exp & 0x1) == 1) {
            result *= 2;
        }
        return result;
    }

    private static double power1(double base, int exp) {
        if (base == 0) {
            return 0;
        }
        if (exp == 0) {
            return 1;
        }
        int absExp = Math.abs(exp);
        double result = powerExponent1(base, absExp);
        if (exp < 0) {
            result = 1/result;
        }
        return result;
    }
    private static double powerExponent1(double base, int exp) {
        for (int i = 0; i < exp - 1; i++) {
            base *= base;
        }
        return base;
    }

    
}
