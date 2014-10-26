/*Given a binary tree, return the preorder traversal of its nodes' values.*/
// Method 1: Recursive
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        preorderTraversal(root, result);
        return result;
    }
    
    public void preorderTraversal(TreeNode root, LinkedList<Integer> result) {
        if (root == null) return ;
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}

// Method 2: Iterative
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<Integer>();
        
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null)  stack.push(node.left);
        }
        return result;
    }
}