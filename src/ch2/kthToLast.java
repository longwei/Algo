package ch2;

import CtCILibrary.*;
/* 2.2
 * implement a algorithm to find the kth to last element of a single linked list
 */
public class kthToLast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
//		System.out.println(nthToLast2(head, 4).data);
		IntWrapper rtCounter = new IntWrapper();
		System.out.println( nthToLast(head, 4, rtCounter).data );
	}
	
	public static class IntWrapper{
		public int value = 0;
	}
	
	//using function stack
	public static LinkedListNode nthToLast(LinkedListNode head, int k, IntWrapper i){
		if (head == null) return null;
		LinkedListNode node = nthToLast(head.next, k, i);
		i.value++;
		if(i.value == k){
			return head;
		}
		return node;
	}
	
	public static int nthToLast(LinkedListNode head, int k){
		if(head == null) return 0;
		int i = nthToLast(head.next, k) + 1;
		if(i == k){System.out.println(head.data);
		}
		return i;
	}
	
	//iterative
	public static LinkedListNode nthToLast2(LinkedListNode head, int k){
		LinkedListNode first = head;
		LinkedListNode last = head;
		for(int i = 0; i < k -1 ; ++i){
			if(last == null){return null;}//error less than k
		    last = last.next;
		}
		if(last == null){return first;}
		while(last.next != null){
			first = first.next;
			last = last.next;
		}
		return first;
	}
}
