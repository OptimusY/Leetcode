/**
 * Reverse the linked list
 */

// Method 1: Iterative
public LinkedListNode reverse(LinkedListNode head) {
	if (head == null || head.next == null) return head;

	LinkedListNode prev = null;
	LinkedListNode curr = head;
	while (curr != null) {
		LinkedListNode next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
	}
	return prev;
}


// Method 2: Recursive
public LinkedListNode reverse(LinkedListNode list){
	/*
	 * If the list is null of contains only
	 * one node, return this list
	 */
	if(list == null || list.next == null)
		return list;

	/*
     * Store information of next node, and unlink the 
     * node from the rest to prevent a loop
     */
	LinkedListNode nextNode = list.next;
	list.next = null;

	/*
	 * Recursively call the reverse() method
	 * to find the tail of the original list
	 */
	LinkedListNode tail = reverse(nextNode);

	nextNode.next = list;

	return tail;
}