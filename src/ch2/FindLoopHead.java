package ch2;

import CtCILibrary.LinkedListNode;

/*
 * 2.6 find the begin of cyclic
 * sol:
 * trick one, key point is to realize the head - target = n - target
 */
public class FindLoopHead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = findBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}
	
	public static LinkedListNode findBeginning(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow ){
				break;
			}
		}
		//Error check if not a loop
		if(fast == null || fast.next == null){
			return null;
		}
		
		/*
		 * now the fast and slow point to the node n that
		 * head - target = n - target
		 */
		fast = head;
		while (fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

}
