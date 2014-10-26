/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the 
 * first two lists.
 */

// Method 1: Iterative
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode(-1);
            if (l1.val < l2.val) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }
            runner.next = node;
            runner = runner.next;
        }
        if (l1 != null) runner.next = l1;
        else runner.next = l2;
        
        return dummy.next;
    }
}

// Method 2: Recursion
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        if (l1.val <= l2.val) {
            head.val = l1.val;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head.val = l2.val;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }
}