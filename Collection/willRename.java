import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> tree = new TreeSet<>();
        
        // Adding elements to the sets
        for (int i = 6; i >= 1; i--) {
            set.add(i);
            tree.add(i);
        }
        
        // Printing the sets
        System.out.println("HashSet: " + set);
        System.out.println("TreeSet: " + tree);
        
        // Iterating through HashSet
        System.out.print("HashSet elements: ");
        for (int ele : set) {
            System.out.print(ele + " ");
        }
        
        System.out.println();
        
        // Iterating through TreeSet
        System.out.print("TreeSet elements: ");
        for (int ele : tree) {
            System.out.print(ele + " ");
        }
        
        PriorityQueue<Integer> pq= new PriorityQueue<>();
         pq.add(234);
        pq.add(23);
        pq.add(3);
        pq.add(34);
       
        pq.add(65);
        System.out.println();
       for (int ele : pq) {
            System.out.print(ele + " ");
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(3);
        q.add(6);
        q.add(1);
        q.add(7);
        System.out.println(q);
        System.out.println(q.get(0));
      
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
