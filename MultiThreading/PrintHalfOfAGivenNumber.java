package threadsInJava;

import java.util.Scanner;


public class PrintHalfOfAGivenNumber extends Thread {
	
	private int[] numbers;
    private Object lock;
    private String threadName;

    public PrintHalfOfAGivenNumber(int[] numbers, Object lock, String threadName) {
        this.numbers = numbers;
        this.lock = lock;
        this.threadName = threadName;
    }

    @Override
    public void run() {
    	System.out.println(threadName+" entered run method");
        for (int num : numbers) {
        	
            synchronized (lock) {
                System.out.println(threadName + " is printing: " + num);
                
                lock.notify();
                try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(threadName + " was interrupted");
                }
            }
        }
        synchronized (lock) {
            lock.notify(); // Ensure the other thread is not stuck waiting
        }
    }
	
    public static void main(String[] args) throws InterruptedException {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int mid = number / 2;

        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[number - mid];

        for (int i = 0; i < mid; i++) {
            firstHalf[i] = i + 1;
        }
        for (int i = 0; i < number - mid; i++) {
            secondHalf[i] = mid + 1 + i;
        }

        Object lock = new Object();

        PrintHalfOfAGivenNumber thread1 = new PrintHalfOfAGivenNumber(firstHalf, lock, "ThreadOne");
        PrintHalfOfAGivenNumber thread2 = new PrintHalfOfAGivenNumber(secondHalf, lock, "ThreadTwo");

        thread1.start();
        thread2.start();
    }
}
