
import java.util.*;
public class StackWithQueue<T>
{
	Queue<T> queue;

	StackWithQueue() {
		queue=new LinkedList<>();

	}

	void push(T value) {

		queue.offer(value);
		System.out.println(value+" is pushed joseph");

	}

	T pop() {
		if(queue.isEmpty()) {
			System.out.println("Cant remove from empty stack");
			return null;
		}

		int len=queue.size();
		T removedElement;

		for(int i=0; i<len-1; i++) {
			removedElement=queue.poll();
			queue.offer(removedElement);
		}
		return queue.poll();
	}

	public static void main(String[] args) {

		StackWithQueue<Integer> swq=new StackWithQueue<>();
		swq.push(1);
		swq.push(2);
		swq.push(3);
		swq.push(4);

		System.out.println(swq.pop());
		System.out.println(swq.pop());
		System.out.println(swq.pop());
		System.out.println(swq.pop());
		System.out.println(swq.pop());

	}
}
