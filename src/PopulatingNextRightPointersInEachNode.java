/**
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Assum that the binary tree is a complete binary tree.
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return ;
        
        if (root.left != null) {
            root.left.next= root.right;
        }
        
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;    
        }
        
        connect(root.left);
        connect(root.right);
    }
}
// Time complexity: O(n)


// Method 2: Iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node;
        TreeLinkNode last = null, curr = null;
        while (root != null) {
            node = root;
            last = null;
            curr = null;
            while (node != null) {
                if (node.left != null && curr != node.left) {
                    curr = node.left;
                } else if (node.right != null) {
                    curr = node.right;
                }
                if (last != null) {
                    if (last != curr)   last.next = curr;
                } else {
                    root = curr;
                }
                last = curr;
                if (node.right == null || curr == node.right) {
                    node = node.next;
                }
            }
        }
    }
}