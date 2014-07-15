package ch2;
import CtCILibrary.*;
/*
 * 2.5 add linked list
 * 
 *   3->1->5 513 
 * + 5->9->1 195
 * = 8->0->7 708
 * 
 * sol:
 * 1. in this way, it acts as the same way we do the math, add two numbers, and pass forward the carry to next(larger significant digit) 
 * 2. keypoint here is to pass the carry down and return the this.node up, as we need the head
 * follow up:
 * 1. padding the linkedlist
 * 2. wrapper for head, and int to tmp the carry
 * 3. first node ready is the LSD, should be in the end of the listm, insertBefore)
 */

public class AddLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(4, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		@SuppressWarnings("unused")
		LinkedListNode lA3 = new LinkedListNode(5, null, lA2);
		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		@SuppressWarnings("unused")
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);	
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());	
//		LinkedListNode list3 = addLists(lA1, lB1, 0);

//		System.out.println("= " + list3.printForward());	
//		
//		int l1 = linkedListToInt(lA1);
//		int l2 = linkedListToInt(lB1);
//		int l3 = linkedListToInt(list3);
//		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));

		LinkedListNode list3 = addListsForward(lA1, lB1);
		System.out.print(list3.printForward());


	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}	

/*
 * this is the easy case for add two link list together
 * as we start from the LSD, padding and alignment are unnecessary
 */

	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
		if( l1 == null && l2  == null && carry == 0) return null;
		int value = (l1 == null? 0: l1.data) 
				+ (l2 == null? 0: l2.data) 
				+ carry;
		LinkedListNode result = new LinkedListNode(value %10, null, null);
		result.setNext(addLists(l1.next, l2.next, value /10));
		return result;
	}


	/*
	 * follow up 
	 * reverse order
	 */

	/*
	 * 1. padding 
	 * 2. return the result + carry
	 */

	public static class SumNode{
		public LinkedListNode sum = null;
		public int carry = 0;
	}

	public static LinkedListNode addListsForward(LinkedListNode l1, LinkedListNode l2){
		//padding	
		SumNode finalSum = addListsForwardHelper(l1, l2);
		if(finalSum.carry != 0){
			return insertBefore(finalSum.sum, finalSum.carry);
		} else {return finalSum.sum;}
	}

	public static SumNode addListsForwardHelper(LinkedListNode l1, LinkedListNode l2){

		if(l1 == null && l2 == null){
			return new SumNode();
		} else {
			SumNode sum = addListsForwardHelper(l1.next, l2.next);
			int value = sum.carry + l1.data + l2.data;
			sum.sum = insertBefore(sum.sum, value % 10);//
			sum.carry = value / 10;
			return sum;
		}
	}

	public static LinkedListNode insertBefore(LinkedListNode head, int n){
		LinkedListNode newNode = new LinkedListNode(n, null, null);
		if( head != null){
			head.prev = newNode;
			newNode.next = head;
		}
		return newNode;
	}

}