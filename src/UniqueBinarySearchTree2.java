/** 
 * Given n, generate all structurally unique BST's (binary search trees)
 * that store values 1...n.
 * -------------------------------Example-------------------------------
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

/**
 * -----------------------------Summary--------------------------------
 * 总结一点，要求出所有组合的问题，一般用dfs；如果要求总数，用dp。
 */

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return create(1, 0);
        return create(1, n);
    }
    
    public List<TreeNode> create(int beg, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (beg > end) {
            result.add(null);
            return result;
        }
        
        for (int i = beg; i <= end; i++) {
            List<TreeNode> leftTree = create(beg, i - 1);
            List<TreeNode> rightTree = create(i + 1, end);
            
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
// Time complexity: O(2 ^ N)