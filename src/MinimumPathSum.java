/**
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along 
 * its path.
 * Note: You can only move either down or right at any point in time.
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)   return -1;
        
        int m = grid.length, n = grid[0].length;
        int[][] ret = new int[m][n];
        ret[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            ret[i][0] = ret[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            ret[0][j] = ret[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ret[i][j] = Math.min(ret[i - 1][j], ret[i][j - 1]) + grid[i][j];
            }
        }
        
        return ret[m - 1][n - 1];
    }
}
// Time complexity: O(n ^ 2)