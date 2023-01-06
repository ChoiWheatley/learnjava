package ch13;

public class ThreadEx16 {
    public static void main(String[] args) {
        var r1 = new Runner();
        var r2 = new Runner();
        var r3 = new Runner();
        var t1 = new Thread(r1, "@");
        var t2 = new Thread(r2, "@@");
        var t3 = new Thread(r3, "@@@");
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            r1.suspend();
            Thread.sleep(2000);
            r2.suspend();
            Thread.sleep(3000);
            r1.resume();
            Thread.sleep(3000);
            r1.stop();
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch (InterruptedException e) {
        }
    }

    public static class Runner implements Runnable {
        private volatile boolean suspended = false;
        private volatile boolean stopped = false;

        @Override
        public void run() {
            while (!stopped) {
                if (!suspended) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " - stopped");
        }

        public void suspend() {
            suspended = true;
        }

        public void resume() {
            suspended = false;
        }

        public void stop() {
            stopped = true;
        }
    }
}
