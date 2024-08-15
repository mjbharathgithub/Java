package threadsInJava;

import java.security.PublicKey;
import java.util.Scanner;

public class ReverseNumPrint extends Thread {
	
	int start,end;
	String threadName;
	Object lock;
	
	public ReverseNumPrint(String threadName,int start,int end,Object lock) {
		// TODO Auto-generated constructor sub
		this.threadName=threadName;
		this.start=start;
		this.end=end;
		this.lock=lock;
	}
	
	public void run() {
		
		for(int i=start;i>=end;i--) {
			synchronized (lock) {
				System.out.println(threadName+" prints : "+i);
				lock.notify();
				
				try {
					Thread.sleep(1000);
					lock.wait();
				}catch (InterruptedException e) {
					// TODO: handle exception
					System.out.println("Interrupted Exception has occured");
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}
				
			}
		}
		synchronized (lock) {
			lock.notify();
		}
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		int n=scanner.nextInt();
		Object lock = new Object();
		ReverseNumPrint thread1=new ReverseNumPrint("thread1", n/2,1,lock);
		ReverseNumPrint thread2=new ReverseNumPrint("thread2", n, n/2+1,lock);
		
		thread1.start();
		thread2.start();
		

	}

}
