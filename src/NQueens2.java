/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, 
 * return the total number of distinct solutions.
 */

public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[] columns = new int[n];
        return placeQueens(n, columns, 0);
    }
    
    public int placeQueens(int n, int[] columns, int row) {
        if (row == n) {
            return 1;
        } else {
            int sum = 0;
            
            for (int col = 0; col < n; col++) {
                if (isValid(row, col, columns)) {
                    columns[row] = col;
                    sum += placeQueens(n, columns, row + 1);
                }
            }
            return sum;
        }
    }
    
    public boolean isValid(int row1, int col1, int[] columns) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];
            
            if (col2 == col1) return false;
            
            int rowDiff = row1 - row2;
            int colDiff = Math.abs(col1 - col2);
            
            if (rowDiff == colDiff) return false;
        }
        return true;
    }
}