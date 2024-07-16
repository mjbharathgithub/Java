class CoffeeShop {
    private static final int MAX_ORDERS = 5;
    private int ordersCount = 0;

    public synchronized void placeOrder(String customerName) throws InterruptedException {
        while (ordersCount == MAX_ORDERS) {
            System.out.println("Coffee Shop is full. " + customerName + " is waiting to place an order...");
            wait();
        }
        ordersCount++;
        System.out.println(customerName + " placed an order. Total orders: " + ordersCount);
        notifyAll();
    }

    public synchronized void serveOrder(String customerName) throws InterruptedException {
        while (ordersCount == 0) {
            System.out.println("No orders to serve. " + customerName + " is waiting to be served...");
            wait();
        }
        ordersCount--;
        System.out.println(customerName + " is served. Remaining orders: " + ordersCount);
        notifyAll();
    }
}

class Customer implements Runnable {
    private String name;
    private CoffeeShop coffeeShop;

    public Customer(String name, CoffeeShop coffeeShop) {
        this.name = name;
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        try {
            coffeeShop.placeOrder(name);
            Thread.sleep(1000); // Simulate time to prepare the coffee
            coffeeShop.serveOrder(name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        }
    }
}

public class CoffeeShopSimulation {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        Thread[] customers = new Thread[10];

        for (int i = 0; i < 10; i++) {
            customers[i] = new Thread(new Customer("Customer " + (i + 1), coffeeShop));
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All customers have been served.");
    }
}
