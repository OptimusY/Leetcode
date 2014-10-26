/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */


// Method 1: With global variable
public class Solution {
    ListNode h = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        h = head;
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        
        return createBST(0, length - 1);
    }
    
    public TreeNode createBST(int beg, int end) {
        if (beg > end) return null;
        
        int mid = beg + (end - beg) / 2;
        TreeNode leftTree = createBST(beg, mid - 1);
        TreeNode root = new TreeNode(h.val);
        root.left = leftTree;
        h = h.next;
        root.right = createBST(mid + 1, end);
        
        return root;
    }
}
// Time complexity: O(N)


// Method 2: Without global variable
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return createBST(head, null);
    }
    
    public TreeNode createBST(ListNode beg, ListNode end) {
        if (beg == end) return null;
        
        ListNode mid = beg, ptr = beg;
        while (ptr != end && ptr.next != end) {// Note: "!=end", not "null" !!
            ptr = ptr.next.next;
            mid = mid.next;
        }
        
        TreeNode root = new TreeNode(mid.val);
        root.left = createBST(beg, mid);
        root.right = createBST(mid.next, end);
        
        return root;
    }
}
// Time complexity: O(N * log N)