package ch13;

import java.util.stream.IntStream;

public class ThredEx1 {
    public static void main(String[] args) {
        // Thread를 상속받은 클래스
        ThreadEx1_1 thread1 = new ThreadEx1_1();

        // Runnable을 상속받은 클래스
        ThreadEx1_2 runnable = new ThreadEx1_2();
        Thread thread2 = new Thread(runnable); // Composition으로 넘겨주네

        // main thread
        IntStream.range(0, 5).forEach(i -> System.out.println(Thread.currentThread().getName()));
        thread1.start();
        thread2.start();

        // thread는 한 번만 실행이 가능하다.
        try {
            thread1.start();
        } catch (IllegalThreadStateException e) {
            e.printStackTrace();
        }

        // 실험, 끊임없이 자기자신을 스레드로 만들어 실행하는 스레드는 어떻게 될까?
        Runnable runnable2 = new RecursiveThread();
        Thread thread3 = new Thread(runnable2);
        thread3.start();
    }
}

/**
 * 차이를 아시겠습니까? Thread와 Runnable
 */

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        IntStream.range(0, 5).forEach((i) -> System.out.println(this.getName()));
    }
}

class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        IntStream.range(0, 5).forEach((i) -> System.out.println(Thread.currentThread().getName()));
    }

}

class RecursiveThread implements Runnable {
    /**
     * 끊임없이 계속 스레드가 생성된다!!
     */
    @Override
    public void run() {
        try {
            int count = 0;
            Runnable runner = new RecursiveThread();
            Thread thread = new Thread(runner);
            thread.start();
            Thread.sleep(1000);
            while (true) {
                System.out.println(Thread.currentThread().getName() + "is called " + ++count +
                        " times! ");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e1) {
            return;
        }
    }
}