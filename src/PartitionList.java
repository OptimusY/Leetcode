/**
 * Given a linked list and a value x, partition it such that 
 * all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in 
 * each of the two partitions.
 * -----------------------------Example---------------------------
 * Given 1->4->3->2->5->2 and x = 3,      return 1->2->2->4->3->5.
 */


// Method 1: Dummy Head
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode small = smallHead, large = largeHead;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
// Time complexity: O(N)


// Method 2: Akward
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode largeHead = null;
        ListNode largeTail = null;
        
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;
            if (node.val < x) {
                if (smallHead == null) {
                    smallHead = node;
                    smallTail = smallHead;
                } else {
                    smallTail.next = node;
                    smallTail = smallTail.next;
                }
            } else {
                if (largeHead == null) {
                    largeHead = node;
                    largeTail = largeHead;
                } else {
                    largeTail.next = node;
                    largeTail = largeTail.next;
                }
            }
        }
        
        if (smallHead == null) return largeHead;
        
        smallTail.next = largeHead;
        return smallHead;
    }
}
// Time complexity: O(N)