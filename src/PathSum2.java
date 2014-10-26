/**
 * Given a binary tree and a sum, find all root-to-leaf paths where
 * each path's sum equals the given sum.
 * ----------------------------Example---------------------------
 * Given the below binary tree and sum = 22,
 *
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 */


public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List<Integer> list = new ArrayList<Integer>();
        rec(root, sum, result, list);
        return result;
    }
    
    public void rec(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) return ;
        
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1); 
            return ;
        }
        
        rec(root.left, sum - root.val, result, list);
        rec(root.right, sum - root.val, result, list);
        list.remove(list.size() - 1);
    }
}
// Time complexity: O(N)