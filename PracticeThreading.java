package threadsInJava;

class TimerA extends Thread{
	public void run() {
		try {
			
			for(int i=0;i<5;i++) {
				System.out.println("TimerA counting :"+i);
				Thread.sleep(2000);
				
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Joseph we got this"+e+" error in thread A");
		}
		
	}
}

class TimerB implements Runnable{
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println("TimerB counting :"+i);
				Thread.sleep(2000);
				
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Joseph we got this"+e+" error in thread B");
		}
		
	}
}

public class PracticeThreading {
	
	public static void main(String[] args) {
		TimerA tmrA =new TimerA();
		TimerB runnable=new TimerB();
		Thread tmrb=new Thread(runnable);
		tmrA.start();
		tmrb.start();
	}

}
