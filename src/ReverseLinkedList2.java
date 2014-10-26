/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass
 * ------------------------------Example--------------------------------
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,  return 1->4->3->2->5->NULL.
 * -------------------------------Note----------------------------------
 * Given m, n satisfy the following condition:  1 ≤ m ≤ n ≤ length of list.
 */

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;  // Note: !!!!
        // Find the node before the reversed region
        ListNode preReverse = dummy;
        for (int i = 1; i < m; i++) preReverse = preReverse.next;
        
        // Do the surgury
        ListNode prevNode = null;
        ListNode currNode = preReverse.next;
        ListNode headNode = preReverse.next;    // Start pos of reversion
        for (int i = 0; i <= n - m; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        // Now currNode is the node after the reversion region
        preReverse.next = prevNode; 
        headNode.next = currNode;   
        
        return dummy.next;
    }
}
// Time complexity: O(N)