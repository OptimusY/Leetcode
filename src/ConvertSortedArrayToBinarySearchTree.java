/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */

// Method 1: Recursive
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        return createBST(num, 0, num.length - 1);
    }
    
    public TreeNode createBST(int[] num, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = createBST(num, left, mid - 1);
        root.right = createBST(num, mid + 1, right);
        return root;
    }
}


// Method 2: Iterative
public class Solution {
    private class NodeE extends TreeNode {
        int i = 0;         //corresponding num index        
        int iL = 0;        //left index of un-searched
        int iR = 0;        //right index of un-searched
        NodeE(int val, int i, int iL, int iR) {
            super(val);
            this.i = i;
            this.iL = iL;
            this.iR = iR;
        }
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
    
        List<NodeE> q = new ArrayList<NodeE>();
        NodeE root = new NodeE(num[num.length / 2], num.length/2, 0, num.length - 1);
        q.add(root);
    
        while (!q.isEmpty()) {
            NodeE n = q.remove(0);
            if (n.i > n.iL) { // left half, from iL to i - 1!
                int nextI = n.iL + (n.i - n.iL) / 2;
                NodeE nL = new NodeE(num[nextI], nextI, n.iL, n.i -1);
                q.add(nL);
                n.left = nL;
            }
            if (n.i < n.iR) { // right half, from i + 1 to iR!
                int nextI = n.i + 1 + (n.iR - n.i) / 2;
                NodeE nR = new NodeE(num[nextI], nextI, n.i + 1, n.iR);
                q.add(nR);
                n.right = nR;
            }
        }
        return root;
    }
}