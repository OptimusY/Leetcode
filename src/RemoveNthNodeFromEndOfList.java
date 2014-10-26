/**
 * Given a linked list, remove the nth node from the end 
 * of list and return its head.
 * ----Example----
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list 
 * becomes 1->2->3->5.
 */

// Method 1: Without dummy head
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;
        if (head.next == null && n == 1) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            if (fast != null) fast = fast.next;
            else return head;   // Note: n > list's length
        }
        
        if (fast == null) {
            return head.next; // Note: n = list's length, remove head!!
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
// Time complexity: O(n)


// Method 2: Use dummy head
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;
        ListNode dumm = new ListNode(0);
        dumm.next = head;
        ListNode fast = dumm, slow = dumm;
        int i = 0;
        
        for (i = 0; i < n; i++) {
            if (fast.next != null) fast = fast.next;
            else break;
        }
        
        if (i == n) {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return dumm.next;
    }
}
// Time complexity: O(n)