public class NumberPrinter {
    private static final int N = 9;
    private static final Object lock = new Object();
    private static int current = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1, N, 3));
        Thread t2 = new Thread(new Printer(2, N, 3));
        Thread t3 = new Thread(new Printer(3, N, 3));

        t1.start();
        t2.start();
        t3.start();
    }

    static class Printer implements Runnable {
        private int threadId;
        private int max;
        private int step;

        Printer(int threadId, int max, int step) {
            this.threadId = threadId;
            this.max = max;
            this.step = step;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (current > max) {
                        break;
                    }

                    if ((current - threadId) % step == 0) {
                        System.out.println("t" + threadId + ":print" + current);
                        current++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }
}
