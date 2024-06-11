package threadsInJava;


public class InterruptInThread {

    public static void main(String[] args) {
        // Create a thread that sleeps for 5 seconds
        Thread sleepingThread = new Thread(new SimpleSleepingRunnable());
        sleepingThread.start();

        // Wait for 1 second and then interrupt the sleeping thread
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread: Interrupting the sleeping thread.");
        sleepingThread.interrupt();
    }
}

class SimpleSleepingRunnable implements Runnable {

    @Override
    public void run() {
        try {
        	for(int i=0;i<5;i++) {
            System.out.println("Sleeping thread: Going to sleep for 5 seconds.");
            Thread.sleep(5000);  // Sleep for 5 seconds
        	}
        } catch (InterruptedException e) {
            System.out.println("Sleeping thread: I was interrupted!");
        }
        
    }
}
