package ch2;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
 * 2.1 remove duplicates from a unsorted linked list
 * sol:
 * 1. with hashtable,ez
 * 2. without hashtable, 
 * 
 * invariant: node in clearzone don't have duplicate node is dirtyzone
 * foreach node cur [begin, end]
 *    foreach node runner [ cur, end]
 *        if duplicate, delete this node.
 *        
 * [clearzone|dirtyzone]
 *        cur   runner
 *
 */
public class RmDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 4);
		System.out.println(head.printForward());
//		insertNth(head, new LinkedListNode(5, null, null), 2);
        deleteDups2(head);
		System.out.println(head.printForward());
	}
	
	public static void deleteDups(LinkedListNode n){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode previous = null;//as I need to delete node
		while(n != null){
			if( table.containsKey(n.data)){
				previous.next = n.next;
			} else{
				table.put(n.data, true);
				previous = n;// maintain the invariant prev
			}
			n = n.next;
		}
	}

    public static void deleteDups2(LinkedListNode head){
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
        LinkedListNode n = head;//as I need to delete node
        assert (head != null);
        table.put(head.data,true);
        while(n.next != null){
            if( table.containsKey(n.next.data)){
                n.next = n.next.next;
            } else{
                table.put(n.next.data, true);
                n = n.next;
            }
        }
    }
	

	//no temporary buffer
	public static void deleteDupsRunner(LinkedListNode head){
		LinkedListNode current = head;
		while(current != null){
			LinkedListNode runner = current;
			while(runner.next != null){
				if(current.data == runner.next.data){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}	
	}
	
	//prefer while loop

	public static LinkedListNode insertFront(LinkedListNode head, LinkedListNode n){
		n.next = head;
		head = n;
		return head;
	}
	public static void append(LinkedListNode head, LinkedListNode n){
		LinkedListNode cur = head;
		if(head == null) {head = n; return;}
		while(cur.next != null){ cur = cur.next;}
		cur.next = n;
	}
	
	public static boolean insertNth(LinkedListNode head, LinkedListNode node, int pos){
		for(int i=0; i < pos; ++i){
			if(head != null){
				head = head.next;//could be null now
			}else{
				return false;//not enough n
			}
		}
		LinkedListNode next = head.next;
		head.next = node;
		node.next = next;
		return true;
	}
	
	public static int count(LinkedListNode head){
		int count = 0;
		for(LinkedListNode cur = head; cur != null; cur = cur.next){
			count++;
		}
		return count;
	}
	
	public LinkedListNode find(LinkedListNode head, LinkedListNode target){
		if(head == null) return null;
		while(head != target && head != null){
		    head = head.next;
		}
		return head;//null if not found
	}
	
}
