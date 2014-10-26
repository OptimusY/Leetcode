/**
 * Given a binary tree, return the zigzag level order traversal of 
 * its nodes' values. (ie, from left to right, then right to left for 
 * the next level and alternate between).
 * ---------------------------Example-------------------------
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<TreeNode> prev = new ArrayList<TreeNode>();
        List<TreeNode> curr = new ArrayList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        curr.add(root);
        list.add(root.val);
        
        boolean flag = true;
        
        while (!curr.isEmpty()) {
            result.add(list);
            prev = curr;
            curr = new ArrayList<TreeNode>();
            list = new ArrayList<Integer>();
            // Note: for both case of flag (true of flase),
            //       loop will always start at the last index !!
            if (flag) {
                for (int i = prev.size() - 1; i >= 0; i--) {
                    if (prev.get(i).right != null) {
                        curr.add(prev.get(i).right);
                        list.add(prev.get(i).right.val);
                    }
                    if (prev.get(i).left != null) {
                        curr.add(prev.get(i).left);
                        list.add(prev.get(i).left.val);
                    }
                }
            } else {
                for (int i = prev.size() - 1; i >= 0; i--) {
                    if (prev.get(i).left != null) {
                        curr.add(prev.get(i).left);
                        list.add(prev.get(i).left.val);
                    }
                    if (prev.get(i).right != null) {
                        curr.add(prev.get(i).right);
                        list.add(prev.get(i).right.val);
                    }
                }
            }
            flag = !flag;
        }
        
        return result;
    }
}
// Time complexity: O(N)