/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */


// Method 1: Iterative
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);    
            if (node.left != null)  s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
        
        while (!s2.isEmpty()) {
            result.add(s2.pop().val);
        }
        
        return result;
    }
}
// Time complexity: O(n)

// Method 2: Recursive
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    public void traverse(TreeNode root, List<Integer> result) {
        if (root == null) return ;
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
    }
}
// Time complexity: O(n)