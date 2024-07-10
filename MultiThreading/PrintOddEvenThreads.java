package threadsInJava;

import java.util.Scanner;

public class PrintOddEvenThreads extends Thread {
	int start,end;
	String threadName;
	Object lock;
	
	public PrintOddEvenThreads(int start,int end,String threadName,Object lock) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
		this.threadName=threadName;
		this.lock=lock;
	}
	
    @Override
    public void run() {
    	// TODO Auto-generated method stub
    	System.out.println(threadName+ " has enterd the run method");
    	
    	for(int i=start;i<=end;i+=2) {
    		synchronized (lock) {
    			System.out.println(threadName+" prints : "+i);
    			lock.notify();
    			
    			try {
					Thread.sleep(120);
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    	}
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num=scanner.nextInt();
		
		int mid=num/2;
		Object lockObject=new Object();
		PrintOddEvenThreads odd=new PrintOddEvenThreads( 1,num,"odd",lockObject );
		PrintOddEvenThreads even=new PrintOddEvenThreads( 2,num-1 ,"even",lockObject);
		
		odd.start();
		even.start();
		
		
	}

}
