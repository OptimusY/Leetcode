/**
 * Given preorder and inorder traversal of a tree, construct the binary tree
 * --------------------------------Note---------------------------------
 * You may assume that duplicates do not exist in the tree.
 */

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return rec(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode rec(int[] pArr, int pBeg, int pEnd, int[] iArr, int iBeg, int iEnd) {
        if (pBeg > pEnd) return null;
        
        // Look for the index of the root in the inorder array
        int rootIndex = 0;        
        for (rootIndex = iBeg; rootIndex <= iEnd; rootIndex++) {
            if (iArr[rootIndex] == pArr[pBeg]) break;
        }
        
        int dist = rootIndex - iBeg;    // calculate the distance
        TreeNode root = new TreeNode(pArr[pBeg]);
        root.left = rec(pArr, pBeg + 1, pBeg + dist, iArr, iBeg, rootIndex - 1);
        root.right = rec(pArr, pBeg + dist + 1, pEnd, iArr, rootIndex + 1, iEnd);
        
        return root;
    }
}
// Time complexity: O(N * log(N))