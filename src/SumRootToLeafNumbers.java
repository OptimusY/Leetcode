/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf
 * path could represent a number.
 * -------------------------------Example--------------------------------
 * The root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sum(root, 0);
    }
    
    public int sum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) return sum;
        
        return sum(root.left, sum) + sum(root.right, sum);
    }
}
// Time complexity: O(N)