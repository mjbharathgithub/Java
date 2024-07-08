// Garbage Collection (GC) in Java is the process by which the Java Virtual Machine (JVM) automatically identifies and discards objects that are no longer needed to free up memory resources. This helps in efficient memory management and prevents memory leaks.

// Key Points of Garbage Collection
// Automatic Memory Management: Java handles memory deallocation automatically, unlike languages like C or C++ where developers have to manage memory manually.
// Heap Memory: All objects in Java are stored in heap memory, and the garbage collector manages the reclamation of memory in the heap.
// GC Algorithms: Java employs various garbage collection algorithms such as Mark-and-Sweep, Generational GC (Young Generation and Old Generation), and more advanced collectors like G1 (Garbage-First) GC.
// Example Demonstrating Garbage Collection
// Let's write a simple program that creates objects and then makes them eligible for garbage collection. We will use System.gc() to suggest the JVM to run the garbage collector, although it's not guaranteed to run immediately.

// Example:

public class GarbageCollectionExample {
    private String objectName;

    public GarbageCollectionExample(String name) {
        this.objectName = name;
    }

    @Override
    protected void finalize() throws Throwable {
        // This method is called by the garbage collector before the object is destroyed
        System.out.println("Garbage collecting " + objectName);
    }

    public static void main(String[] args) {
        // Creating objects
        GarbageCollectionExample obj1 = new GarbageCollectionExample("Object 1");
        GarbageCollectionExample obj2 = new GarbageCollectionExample("Object 2");
        
        // Making the objects eligible for garbage collection
        obj1 = null;
        obj2 = null;
        
        // Suggesting JVM to run the garbage collector
        System.gc();
        
        // Pausing the program to ensure garbage collection happens
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main method");
    }
}
// Explanation:
// Object Creation: Two objects, obj1 and obj2, are created.
// Making Objects Eligible for GC: Both objects are set to null, making them eligible for garbage collection since there are no references to them.
// Requesting GC: System.gc() is called to suggest that the JVM run the garbage collector. Note that this is just a request, and the JVM may choose to ignore it.
// Finalize Method: The finalize() method is overridden to print a message when the object is being garbage collected. This method is called by the garbage collector before the object is destroyed. However, it's important to note that the use of finalize() is generally discouraged due to its unpredictability and performance costs.

// Note:
// Unpredictability: The actual time when the garbage collector runs is unpredictable, and relying on System.gc() is not a good practice for production code.
// Finalization: The finalize() method is deprecated in Java 9 and removed in Java 18. It's not recommended to use it in new code.
// Memory Management: Modern applications should rely on proper memory management and design patterns rather than manual intervention with GC.
// Garbage collection in Java is a powerful feature that aids in efficient memory management, allowing developers to focus on the application logic rather than low-level memory management.
