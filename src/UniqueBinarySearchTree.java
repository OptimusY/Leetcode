/* 
 * Given n, how many structurally unique BST's that 
 * store values 1...n?
 */

/**
 * -----------------------------Summary--------------------------------
 * 总结一点，要求出所有组合的问题，一般用dfs；如果要求总数，用dp。
 */

// Method 1: DP (Hint: Count[i] = ∑ Count[0...k] * [ k+1....i] , 0 <= k < i-1)
public class Solution {
    public int numTrees(int n) {
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] += count[j - 1] * count[i - j];
            }
        }
        
        return count[n];
    }
}
// Time Complexity: O(n^2)

// Method 2: Recursion
public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }
}
// Time complexity: O(2^n)