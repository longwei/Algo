package ch2;
import CtCILibrary.*;
public class Reverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		System.out.println(reverse(head).printForward());

	}
	
	public static LinkedListNode reverse(LinkedListNode node){
		LinkedListNode next = null;
		LinkedListNode prev = null;
		while(node != null){
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
	}
}
