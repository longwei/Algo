package ch2;
import CtCILibrary.*;

/*  2.4
 *  partition a linked list so that all node less than x come before all nodes greater or larger than
 *  sol:
 *  pointer trick
 *  TODO: using pivot
 */

public class Partition {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}		
		/* Partition */
//		LinkedListNode h = partition(head, 5);
		LinkedListNode h = part(head, 5);
		
		/* Print Result */
		System.out.println(h.printForward());

	}
	
	public static LinkedListNode partition(LinkedListNode head, int x){
		LinkedListNode beforeHead = null;
		LinkedListNode beforeTail = null;
		LinkedListNode afterHead = null;
		LinkedListNode afterTail = null;
		
		while(head != null){
			LinkedListNode next = head.next;
			head.next = null;
			if(head.data < x){
				//append to before
				if(beforeHead == null){ 
					beforeHead = head;
					beforeTail = head;
					}else{
						beforeTail.next = head;
						beforeTail = head;
					}
			} else{
				//append to after
				if(afterHead == null){
					afterHead = head;
					afterTail = head;
				}else{
					afterTail.next = head;
					afterTail = head;
				}
			}
			head = next;
		}
		//merge
		beforeTail.next = afterHead;
		return beforeHead;
	}
	
	
	/*
	 * move append to different function
	 */
	public static LinkedListNode part(LinkedListNode head, int x){
		LinkedListNode[] first = {null, null};//0 for head, 1 for tail
		LinkedListNode[] second = {null, null};
		while(head != null){
			LinkedListNode cur = head;
			head = head.next;
			cur.next = null;//disconnect
			if(cur.data < x){
				first = append(first[0], first[1], cur);
			} else {//append to after
				second = append(second[0], second[1], cur);
			}	
		}
		first[1].next = second[0];
		return first[0];
	}
	
	public static LinkedListNode[] append(LinkedListNode head, LinkedListNode tail, LinkedListNode node){
		assert(node != null);
		if(tail == null){
			assert(head == null);
			head = node;
			tail = node;
		}else{
			tail.next = node;
			tail = node;
		}
		LinkedListNode[] ret = {head, tail};
		return ret;
	}
	
}
