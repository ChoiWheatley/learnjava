package ch13;

import java.util.stream.IntStream;

public class ThreadEx4 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        print(300, "-", 10);
        long first = (System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        print(300, "|", 10);
        long second = (System.currentTimeMillis() - startTime);

        System.out.println("\nfirst: " + first + "\nsecond " + second);
    }

    public static void print(int times, String str, long sleepTime) {
        IntStream.range(0, times).forEach(i -> {
            try {
                System.out.printf(str);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        });
    }
}
