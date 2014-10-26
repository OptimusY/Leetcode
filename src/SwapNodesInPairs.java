/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example: given 1->2->3->4, you should return 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy, curr = head;
        ListNode next = head.next, post = next.next;
        
        while (curr != null) {
            prev.next = next;
            next.next = curr;
            curr.next = post;
            
            if (post == null || post.next == null) break;
            
            prev = curr;
            curr = prev.next;
            next = curr.next;
            post = next.next;
        }
        return dummy.next;
    }
}
// Time complexity: O(n)