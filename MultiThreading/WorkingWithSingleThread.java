package threadsInJava;

class A extends Thread{
	
	public void run() {
		for(int i=0;i<5;i++) { System.out.println("hello    count:"+(i+1));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}
	
}

class B extends Thread{
	public void run() {
		for(int i=0;i<5;i++) { System.out.println("World   count: "+(i+1));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	}
	
}


class Hello extends Thread {
    private final Object lock;

    public Hello(Object lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    System.out.println("Hello");
                    lock.notify();
                    if (i < 4) {
                        lock.wait(); // Wait for the other thread to print
                    }
                }
                Thread.sleep(2000); // Sleep for 2 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Joseph there is an error in Hello Thread");
        }
    }
}

class Name extends Thread {
    private final Object lock;

    public Name(Object lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            Thread.sleep(1000); // Initial delay to ensure interval
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    System.out.println("Joseph");
                    lock.notify();
                    if (i < 4) {
                        lock.wait(); // Wait for the other thread to print
                    }
                }
                Thread.sleep(2000); // Sleep for 2 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Joseph there is an error in Printing your name");
        }
    }
}

public class WorkingWithSingleThread {
	{
		System.out.println("Instance Block");
	}
	
    public static void main(String[] args) throws InterruptedException {
//        Object lock = new Object();
//        Hello hello = new Hello(lock);
//        Name name = new Name(lock);
//
//        hello.start();
//        name.start();
    	A a=new A();
    	
    	B b=new B();
    	a.start();
    	if(a.isAlive()) System.out.println("A is alive");
    	a.join();
    	if(!a.isAlive()) System.out.println("A is dead");
    	b.start();
    	
    }
    
}
