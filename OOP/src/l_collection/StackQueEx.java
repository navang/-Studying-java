package l_collection;
import java.util.*;
public class StackQueEx {

	public static void main(String[] args) { 
		// Stack - LIFO ( Last In First Out) - stack.pop()
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		// Queue = FIFO (First In First Out) - queue.poll()
		Queue queue =new LinkedList();
		queue.offer("가");
		queue.offer("나");
		queue.offer("다");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
