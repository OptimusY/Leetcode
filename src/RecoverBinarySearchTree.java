/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * ---------------------------------Note-------------------------------
 * A solution using O(n) space is pretty straight forward. 
 * Could you devise a constant space solution???????????????
 */

public class Solution {
    TreeNode prev = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return ;
        inorder(root);
        swap(first, second);
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return ;
        
        inorder(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                if (first == null) first = prev;
                second = root;
            }
            prev = root;
        }
        inorder(root.right);
    }
    
    public void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
// Time complexity : O(N);
// Space complexity: O(N);