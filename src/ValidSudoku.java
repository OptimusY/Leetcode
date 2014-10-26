/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are 
 * filled with the character '.'.
 * A partially filled sudoku is VALID.
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0) return false;
        return checkRowsCols(board) && checkSubs(board);
    }
    
    public boolean checkRowsCols(char[][] board) {
        HashSet<Integer> rows, cols;
        for (int i = 0; i < 9; i++) {
            rows = new HashSet<Integer>();
            cols = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    if (rows.contains(val)) return false;
                    else rows.add(val);
                }
                if (board[j][i] != '.') {
                    int val = board[j][i] - '0';
                    if (cols.contains(val)) return false;
                    else cols.add(val);
                }
            }
        }
        return true;
    }
    
    public boolean checkSubs(char[][] board) {
        HashSet<Integer> set = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set = new HashSet<Integer>();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i * 3 + m][j * 3 + n] != '.') {
                            int val = board[i * 3 + m][j * 3 + n] - '0';
                            if (set.contains(val)) return false;  
                            else set.add(val);
                        }
                    }
                }
            }
        }
        return true;
    }
}
// Time complexity: O(n ^ 2)