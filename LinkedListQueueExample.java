import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        // Creating a Queue using the LinkedList class
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        // Printing the elements of the queue
        System.out.println("Queue: " + queue);

        // Removing elements from the queue
        int removedElement = queue.remove();
        System.out.println("Removed Element: " + removedElement);

        // Peeking at the front element of the queue
        int frontElement = queue.peek();
        System.out.println("Front Element: " + frontElement);

        // Printing the elements of the queue after removal
        System.out.println("Queue after removal: " + queue);

        // Checking if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);
    }
}
