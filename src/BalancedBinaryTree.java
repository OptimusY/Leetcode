/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 */

// Method 1: Optimized
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (checkHeight(root) != -1) return true;
        else return false;
    }
    
    public int checkHeight(TreeNode root) {
        if (root== null) return 0;
        
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1;
        
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
// Time complexity: O(n)

// Method 2: normal one
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode root) {
        if (root== null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
// Time complexity: O(n ^ 2)