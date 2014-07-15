package ch3;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

/*
 * 3.2 push, pop, and min ops with o(1) time
 * sol: the key part here is how to implement min ops.
 * I can have another stack, maintain the min value of the main stack.
 * 
 */
public class StackWithMin extends Stack<Integer>{
	Stack<Integer> min = new Stack<Integer>();
	
	public void push(int value){
		super.push(value);
		if(min.isEmpty()) min.push(value);
		if(min() >= value) min.push(value);
		//need to keep duplicate copy of min value
	}
	
	public Integer pop(){
		int value = super.pop();
		if( min.peek() == value) {min.pop();}
		return value;
	}
	public int min(){
		if (min.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return min.peek();
		}
	}
	
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			System.out.println("Popped " + stack.pop() + ", ");
			System.out.println("New min is " + stack.min() + ", ");
		}

	}

}
