package FastSlowPointers;
/*   

 Given the head of a LinkedList with a cycle, find the length of the cycle.

 */
public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle length: " + Pattern2.findCycleLength(head));

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList cycle length: " + Pattern2.findCycleLength(head));
	}

	private static int findCycleLength(ListNode head) {
		ListNode cycleNode = null;
		if((cycleNode = getCycleNode(head)) == null)
			return 0;
		else
			return calculateLengthCycle(cycleNode);
	}
	private static int calculateLengthCycle(ListNode cycleNode) {
		int count = 0;
		ListNode tempNode = cycleNode;
		do{
			tempNode = tempNode.next;
			count += 1;
		}while(tempNode != cycleNode);
		return count;
	}

	private static ListNode getCycleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return slow;

		}
		return null;
	}

}
