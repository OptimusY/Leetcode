/**
 * Given inorder and postorder traversal of a tree, construct the binary tree
 * --------------------------------Note--------------------------------
 * You may assume that duplicates do not exist in the tree.
 */

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        return rec(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode rec(int[] inArr, int inBeg, int inEnd, int[] postArr, int postBeg, int postEnd) {
        if (inBeg > inEnd || postBeg > postEnd) return null;
        
        TreeNode root = new TreeNode(postArr[postEnd]);
        int rootIndex = 0;
        for (rootIndex = inBeg; rootIndex <= inEnd; rootIndex++) {
            if (inArr[rootIndex] == postArr[postEnd]) break;
        }
        
        int dist = rootIndex - inBeg;
        root.left = rec(inArr, inBeg, rootIndex - 1, postArr, postBeg, postBeg + dist - 1);
        root.right = rec(inArr, rootIndex + 1, inEnd, postArr, postBeg + dist, postEnd - 1);
        
        return root;
    }
}
// Time complexity: O(N * log N)