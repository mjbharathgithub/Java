package threadsInJava;
class PingPong {
    private boolean pingTurn = true;

    public synchronized void printPing() throws InterruptedException {
        while (!pingTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("*****");
        Thread.sleep(2000);
        pingTurn = false;
        notify();
    }

    public synchronized void printPong() throws InterruptedException {
        while (pingTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("++++++");
        Thread.sleep(2000);
        pingTurn = true;
        notify();
    }
}

class PingThread extends Thread {
    private PingPong pingPong;

    public PingThread(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
				pingPong.printPing();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}

class PongThread extends Thread {
    private PingPong pingPong;

    public PongThread(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
				pingPong.printPong();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}

public class PingPongDemo {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        PingThread pingThread = new PingThread(pingPong);
        PongThread pongThread = new PongThread(pingPong);

        pingThread.start();
        pongThread.start();
    }
}
