package ch3;

import java.util.Stack;

/*
 * 3.5 implement queue with two stacks
 * sol:
 * push:s1.push
 * 
 * pop: if s2.isEmpty, 
 *         shift s1 to s2.
 */
public class QueueWithTwoStacks {
	Stack<Integer> s1, s2;
	
	public QueueWithTwoStacks(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
		
	}
	
	public void enqueue(int value){
		s1.push(value);
	}
	public int dequeue(){
		if(s2.isEmpty()){
			shift();
		}
		return s2.pop();
	}
	
	private void shift(){
		assert(s2.isEmpty());
		while(s1.size() > 0 ){
			s2.push(s1.pop());
		}
	}
	public String toString(){
		return s1.toString() + "\n" + s2.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		System.out.println(queue.toString());
	}

}
