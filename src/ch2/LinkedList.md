LinkedList
//TODO recursive problems


Basic Ops
=========
* Insert
* Delete
* Traversing

* Delete Lists
* Count
* find the nth element

----
single, double or circular
sorted?
head and tail reference
----
sentinel node vs Null
iterator i = list.begin();
*list.end() = x;
while(*i != x){++i;}
return i;


-----------
From other perspective:
*Working with head, keep a copy of it. that means that reference to the head must be updated.
public ListElement insertInFront(Node head, Data data){
	Node newHead = new Node(data);
	newHead.next = head;
	return newHead;
}

*working with other node, Traversing from some node of the list and Must check for the end of the list.
always test for the end of a linked list as you traverse it,
public Node find(Node head, Data data){
	if(head == null) return null;
	while(head.data != data && head != null){
	    head = head.next;
	}
	return head;//null if not found
}

Tips
=========
*write loop as for which make the initialization and harder to omit the ++
for(current = head; current != null; current = current.next){}

* Pay attention to head case for the setup
* check the null ptr
* update the head or tail as necessary
* two pointer trick.

boolean deleteNode(Node head, Data deleteMe){
    Node current = head;
    
    //edge case
    if(head.data == deleteMe){
        current.next = current.next.next;
        return true;
    }
    while(current){
        if(current.next.data = deleteMe){
            current.next = current.next.next;
            return true;
        }
        current = current.next;
    }
    return false;
}


//TODO problems

sortedInsert()
insertSort()
MoveNodes()





***Problems***
Stack Implementation: 
Dynamic Array - random constant access time, but ops always on the top(end) of stack. resize is also a time-consumping ops.
Linked List   - overhead when size is small.
Interface:
push: ensure memory allocation successed
pop: pop a empty stack; null valus is valid? 
------------
Maintain Tail Pointer(edges cases matters)
remove & insertAfter
nothing changes, only updates them when necessary(head or tail)
general case and edge cases of edges cases
(I am think linkedlist with head, body, and tail => length of 0, 1, 2) | null argument
Finding bugs
1. argument 
2. each function
3. data come out of the function
4. error conditions
------------------

List flattening
class Node{
	Node next;
	Node prev;
	Node child;
	Int  Value;
}
easy way: Traverse and copy.
--------------------
Start at the beginning of the first level
while you are not at the end of the first level
  if the current node has a child
    append the child node to the end of the first level
    update the tail pointer
  Advance to next node

void flattenList(Node head, Node tail){
	Node current = head;
	while(current){
	    if (curNode.child){
	        append(current.child, tail);
	    }
	    current = current.next
	}
}

void append(Node child, Node tail){
	Node current
	tail.next = child;
	child.prev = tail;
	//update tail pointer
	tail = child.tail;
}


isCyclic
start with two pointer {currentm runner} = head of the list
While()
  if fast reach null
  if fast move on current
  fast++ ++;
  current++;


