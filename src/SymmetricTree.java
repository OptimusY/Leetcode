/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 */

// Method 1: Iterative
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        List<TreeNode> prev = new ArrayList<TreeNode>();
        List<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        
        while (!curr.isEmpty()) {
            prev = curr;
            curr = new ArrayList<TreeNode>();
            int beg = 0, end = prev.size() - 1;
            while (beg < end) {
                if (prev.get(beg) == null && prev.get(end) == null) {
                    beg++;
                    end--;
                } else if (prev.get(beg) == null || prev.get(end) == null) {
                    return false;
                } else if (prev.get(beg).val != prev.get(end).val) {
                    return false;
                } else {
                    beg++;
                    end--;
                }
            }
            for (TreeNode node : prev) {
                if (node == null) continue ;
                if (node.left != null) curr.add(node.left);
                else curr.add(null);
                if (node.right != null) curr.add(node.right);
                else curr.add(null);
            }
        }
        return true;
    }
}
// Time complexity: O(N)


// Method 2: Recursive
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    public boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        
        if (tree1.val != tree2.val) return false;
        return isMirror(tree1.left, tree2.right) &&
               isMirror(tree1.right, tree2.left);
    }
}
// Time complexity: O(n)