/*Given a binary tree, return the inorder traversal of its nodes' values.*/
// Method 1: Recursive
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        inorderTraversalHelper(root, result);
        return result;
    }
    
    public void inorderTraversalHelper(TreeNode root, LinkedList<Integer> result) {
        if (root == null) return ;
        
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
}

// Method 2: Iterative
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<Integer>();
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        
        return result;
    }
}