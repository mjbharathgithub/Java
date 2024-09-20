
import java.util.*;
public class QueueWithStack<T>
{
    Stack<T> stack1,stack2;
    
    QueueWithStack(){
        stack1=new Stack<>();
        stack2=new Stack<>();
        
    }
    
    void enque(T value){
        
        stack1.push(value);
        System.out.println(value+" is enqueued joseph");
        
    }
    
    T dequeue(){
        if(stack2.isEmpty() && stack1.isEmpty()){
            System.out.println("Cant remove from empty queue");
            return null;
        }
        
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		QueueWithStack<Integer> qws=new QueueWithStack<>();
		
		qws.enque(1);
		qws.enque(2);
		qws.enque(3);
		qws.enque(4);
		qws.enque(5);
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		System.out.println(qws.dequeue());
		
	//	for(int ele:qws) System.out.println(ele);
	}
}
