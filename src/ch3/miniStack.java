package ch3;

/**
 * Created by longwei on 7/31/2014.
 * 3.2
 *
 * This has no different as extends the stack base class. I preferred this one
 */

import CtCILibrary.AssortedMethods;

import java.util.Stack;


public class miniStack {
    private Stack<Integer> stack, min;
    public int size(){
        return stack.size();
    }
    public void push(int x){
        stack.push(x);
        if(min.size() == 0){
            min.push(x);
        }
        if(x <= min.peek()){
            min.push(x);
        }
    }
    public int pop(int x){
        int ret = stack.pop();
        if( ret == min.peek()){
            min.pop();
        }
        return ret;
    }

    public int min(){
        if(stack.isEmpty()){
            return Integer.MAX_VALUE;
        }else {
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
