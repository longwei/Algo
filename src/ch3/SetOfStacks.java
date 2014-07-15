package ch3;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 3.3
 * create a new stack ifone exceeds the capacity.
 * api:
 * push, pop, isEmpty
 * 
 * follow up:
 * implement popAt(int index)
 * sol:
 * 1. what if the just pop at random stack without effect on neighbor stack, 
 * well, it could be, but the caller need to aware that not all the stacks are operating in full capacity.
 * 2. rollover system
 *    
 *     * *
 *     * * *
 *     * * *
 *  
 *  
 *  pseudo code
 *  
 *  top lever:
 *  returnV = my.pop()
 *  if I have next,
 *    value = my.next.removeBottom
 *    push(value)
 *  else if my.isEmpty
 *    clean my self.
 *  return returnV
 *  
 *  other levers:
 *  returnV = my.removeBotton();
 *  if I have next,
 *    value = my.next.removeBottom
 *    push(value)
 *  else if my.isEmpty
 *    clean my self.
 *  return returnV
 *  
 */
public class SetOfStacks {
	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	static final int UPP_LIMMIT = 3;
	
	public void push(int value){
		Stack<Integer> stack = getLastStack();
		if(stack != null && stack.size() < UPP_LIMMIT){
			stack.push(value);
		} else {
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.add(value);
			stacks.add(newStack);
		}
		
	}
	public int pop(){
		Stack<Integer> last = getLastStack();
		assert(last != null);
		int ret = last.pop();
		if(last.isEmpty()){
			stacks.remove(stacks.size() - 1);
		}
		return ret;
	}
	
	private Stack<Integer> getLastStack(){
		if(stacks.isEmpty()){
			return null;
		} else {
			return stacks.get(stacks.size() - 1);
		}
	}
	public String toString(){
		StringBuffer ret = new StringBuffer();
		for(Stack<Integer> stack: stacks)
			ret.append(stack.toString() + "\n");
		return ret.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks stacks = new SetOfStacks();
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		System.out.print(stacks);
		System.out.print(stacks.pop());
		System.out.print(stacks.pop());
		System.out.print(stacks.pop());
		System.out.print("\n" + stacks);
	}

}
