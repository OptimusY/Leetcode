/**
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in place.
 */


// Method 1: Without using extra space
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        
        int m = matrix.length, n = matrix[0].length;
        boolean fr0 = false, fc0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) fc0 = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) fr0 = true;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) matrix[i][j] = 0;
            }
        }
        
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) matrix[i][j] = 0;
            }
        }
        
        if (fr0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (fc0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    } 
}
// Time complexity: O(n ^ 2)