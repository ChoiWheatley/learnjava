package ch13;

public class ThreadEx5 {
    static long startTime = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadEx5_1 thread = new ThreadEx5_1();
        thread.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; ++i) {
            System.out.printf("-");
            for (int j = 0; j < 100000; ++j) {
            }
        }
        System.out.print("\n1: " + (System.currentTimeMillis() - startTime) + "\n");
    }
}

class ThreadEx5_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; ++i) {
            System.out.printf("|");
            for (int j = 0; j < 100000; ++j) {
            }
        }
        System.out.print("\n2: " + (System.currentTimeMillis() - ThreadEx5.startTime) + "\n");
    }
}