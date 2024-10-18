import java.util.*;

public class Main extends Thread {
    int start, end;
    Object lock;
    String tName;
    int threadId;
    static int currentTurn = 1;  // Shared state to control the turn of each thread

    Main(int start, int end, String tName, int threadId, Object lock) {
        this.start = start;
        this.end = end;
        this.tName = tName;
        this.threadId = threadId;
        this.lock = lock;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            synchronized (lock) {
                while (currentTurn != threadId) {
                    try {
                        lock.wait();  // Wait until it's this thread's turn
                    } catch (InterruptedException e) {
                        System.out.println("There is an error Joseph...");
                    }
                }

                // It's this thread's turn now
                System.out.println(tName + " printing: " + i);

                // Move the turn to the next thread (1 -> 2 -> 3)
                currentTurn = currentTurn % 3 + 1;

                lock.notifyAll();  // Wake up all waiting threads to check whose turn it is

                try {
                    Thread.sleep(800);  // Simulating some work
                } catch (InterruptedException e) {
                    System.out.println("Error in sleeping");
                }
            }
        }

        System.out.println(tName + " has successfully Executed Joseph...");
    }

    public static void main(String[] args) {
        Object lock = new Object();

        // Create 3 threads with unique IDs for turn control
        Main thread1 = new Main(1, 3, "Thread1", 1, lock);
        Main thread2 = new Main(4, 6, "Thread2", 2, lock);
        Main thread3 = new Main(7, 9, "Thread3", 3, lock);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
