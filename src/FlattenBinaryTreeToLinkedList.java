/**
 * Given a binary tree, flatten it to a linked list in-place.
 * -------------Example-------------
 * Given
 *
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * ----------------Hint--------------
 * If you notice carefully in the flattened tree, each node's right child 
 * points to the next node of a pre-order traversal.
 */


public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return ;
        rec(root);
    }
    
    public TreeNode rec(TreeNode root) {
        if (root == null) return root;
        
        TreeNode flatL = rec(root.left);
        TreeNode flatR = rec(root.right);
        
        root.right = flatL;
        root.left = null;
        
        TreeNode runner = flatL;
        if (runner != null) {
            while (runner.right != null) {
                runner = runner.right;
            }
            runner.right = flatR;
        } else {
            root.right = flatR;
        }
        
        return root;
    }
}
// Time complexit: O(N*logN)