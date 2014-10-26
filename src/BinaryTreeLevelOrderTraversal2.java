/**
 * Given a binary tree, return the bottom-up level order traversal of its 
 * nodes' values. (ie, from left to right, level by level from leaf to root)
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<TreeNode> curr = new ArrayList<TreeNode>();
        List<TreeNode> prev = new ArrayList<TreeNode>();
        List<Integer> level = new ArrayList<Integer>();
        curr.add(root);
        level.add(root.val);
        
        while (!curr.isEmpty()) {
            result.add(0, level);   // Trick is here!
            prev = curr;
            curr = new ArrayList<TreeNode>();
            level = new ArrayList<Integer>();
            for (TreeNode node : prev) {
                if (node.left != null) {
                    curr.add(node.left);
                    level.add(node.left.val);
                } 
                if (node.right != null) {
                    curr.add(node.right);
                    level.add(node.right.val);
                }
            }
        }
        
        return result;
    }
}
// Time complexity: O(n)