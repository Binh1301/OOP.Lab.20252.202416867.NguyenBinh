package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    private static final int ITERATIONS = 65536;

    private static long concatWithPlus() {
        Random random = new Random(123);
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            result += random.nextInt(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("Length (+): " + result.length());
        return end - start;
    }

    private static long concatWithStringBuffer() {
        Random random = new Random(123);
        long start = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            buffer.append(random.nextInt(2));
        }
        String result = buffer.toString();
        long end = System.currentTimeMillis();
        System.out.println("Length (StringBuffer): " + result.length());
        return end - start;
    }

    private static long concatWithStringBuilder() {
        Random random = new Random(123);
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            builder.append(random.nextInt(2));
        }
        String result = builder.toString();
        long end = System.currentTimeMillis();
        System.out.println("Length (StringBuilder): " + result.length());
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println("Time with + operator: " + concatWithPlus() + " ms");
        System.out.println("Time with StringBuffer: " + concatWithStringBuffer() + " ms");
        System.out.println("Time with StringBuilder: " + concatWithStringBuilder() + " ms");
    }
}
