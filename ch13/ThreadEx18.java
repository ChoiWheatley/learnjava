package ch13;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ThreadEx18 {
    public static void main(String[] args) throws InterruptedException {
        List<Runner> runners = Arrays.asList(
                new Runner("@"),
                new Runner("@@"),
                new Runner("@@@"));
        runners.forEach(r -> r.start());
        Thread.sleep(2000);
        runners.get(0).suspend();
        Thread.sleep(2000);
        runners.get(1).suspend();
        Thread.sleep(3000);
        runners.get(0).resume();
        Thread.sleep(3000);
        runners.get(0).stop();
        runners.get(1).stop();
        Thread.sleep(2000);
        runners.get(2).stop();
    }

    public static class Runner implements Runnable {
        private volatile boolean suspended = false;
        private volatile boolean stopped = false;

        Thread th;

        public Runner(String name) {
            th = new Thread(this, name);
        }

        @Override
        public void run() {
            while (!stopped) {
                if (!suspended) {
                    System.out.println(th.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(th.getName() + " - interrupted");
                    }
                } else {
                    Thread.yield(); // busy waiting 대신에 현재 스레드를 큐에 삽입한다.
                }
            }
            System.out.println(th.getName() + " - stopped");
        }

        public void toggleSuspend() {
            suspended = !suspended;
            th.interrupt();
            System.out.println(th.getName() + " - interruption status: " +
                    (suspended ? "interrupted" : "not interrupted"));
        }

        public void suspend() {
            if (suspended == false) {
                toggleSuspend();
            }
        }

        public void resume() {
            if (suspended == true) {
                toggleSuspend();
            }
        }

        public void stop() {
            stopped = true;
            th.interrupt(); // interrupt를 걸어 sleep상태 (WAIT)에서 빠져나와 바로 태스크를 양보하도록 만든다.
            System.out.println(th.getName() + " - interrupted by stop()");
        }

        public void start() {
            th.start();
        }
    }
}
