package ch3;

import java.util.Stack;

/*
 * 3.6
 * sort a stack in ascending order, 
 * support ops like push, pop, peek, isEmpty
 *       12
 *  10    8
 *  5     3
 *  
 *  0. all in s1
 *  1. keep poped. move element from s1, s2, the order is same.
 *  2. invariant, sorted stack is alway sorted. find the right place to push.
 */
public class SortedStack {
	Stack<Integer> unsorted,cache,sorted;
	public SortedStack(){
		unsorted = new Stack<Integer>();
		cache = new Stack<Integer>();
		sorted = new Stack<Integer>();
	}
	
	public void initil(int[] input){
		for(int i : input){
			unsorted.push(i);
		}
	}
		
	public void sort(){
		assert(unsorted.size() > 0);
		while(unsorted.size() > 0){
			int cur = unsorted.pop();
			if(sorted.isEmpty()) {sorted.push(cur); continue;}
			while( !sorted.isEmpty() && sorted.peek() > cur){
				cache.push(sorted.pop());
			}
			sorted.push(cur);
			while(cache.size() > 0){
				sorted.push(cache.pop());
			}
		}
	}
	public String toString(){
		return sorted.toString();
	}
	
	
	
	public static void main(String[] args) {
		SortedStack stack = new SortedStack();
		int[] input = {3,2,1,4,5,6,7,7,7,8};
		stack.initil(input);
		System.out.println(stack.toString());
		stack.sort();
		System.out.println(stack.toString());
		

	}

}
