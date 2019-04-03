package meettooffer.chapter6;

import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OnlyAdd {
    public static void main(String[] args) {
        int length = 10;
        OptionalInt max = IntStream.generate(new IntSupplier() {
            int sum = 0;
            int start = 0;

            @Override
            public int getAsInt() {
                sum += ++start;
                return sum;
            }
        }).limit(10).max();
        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        }
    }
}
