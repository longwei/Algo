package ch3;
/*
 * 3.1 use a single array for three stacks
 * sol:
 * 1. fixed size, each sub arrays just take 1/3 of the space
 *  * 2. dynamic, 
 * [|->......<-|....<-|]
 *  1          2      3
 *  need to keep the tails
 */
public class OneArrayThreeStack {
	static int stacksize = 10;
	static int[] buffer = new int[stacksize * 3];
	static int[] sp = {-1, -1 ,-1};
	
	public static void push(int stackNum, int value) throws Exception{
		if(sp[stackNum] +1 >= stacksize ){
			throw new Exception("overflow");
		}
		sp[stackNum] ++;
		buffer[absPosOfStack(stackNum)] = value;
	}
	public static int pop(int stackNum) throws Exception{
		if(isEmpty(stackNum)){
			throw new Exception("underflow");
		}
		int ret = buffer[absPosOfStack(stackNum)];
		sp[stackNum]--;
		return ret;
	}
	public static int peek(int stackNum){
		return buffer[absPosOfStack(stackNum)];
	}
	public static boolean isEmpty(int stackNum){
		return (absPosOfStack(stackNum) == -1);
		
	}
	static public int absPosOfStack(int stackNum){
		return stackNum * stacksize + sp[stackNum];
	}

	public static void main(String[] args) throws Exception {
		push(2, 4);
		System.out.println("Peek 2: " + peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));

	}
}
