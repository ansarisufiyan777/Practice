package FastSlowPointers;

import java.util.HashSet;

/*  

 Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.

 */

class ListNode {
	int value = 0;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}

public class Pattern1 {

	public static boolean hasCycle(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		while(fastPointer!= null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if(slowPointer == fastPointer)
				return true;
		}
		
		return false;
	}
	public static boolean hasCycle_HT(ListNode head) {
		ListNode temp = head;
		HashSet<ListNode> map= new HashSet<ListNode>();
		while(temp != null) {
			if(map.contains(temp))
				return true;
			map.add(temp);
			temp = temp.next;
		}
		
		return false;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle: " + Pattern1.hasCycle(head));
		System.out.println("LinkedList has cycle: " + Pattern1.hasCycle_HT(head));

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle: " + Pattern1.hasCycle(head));
		System.out.println("LinkedList has cycle: " + Pattern1.hasCycle_HT(head));
		
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has cycle: " + Pattern1.hasCycle(head));
		System.out.println("LinkedList has cycle: " + Pattern1.hasCycle_HT(head));


	}

}

