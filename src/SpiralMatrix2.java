/**
 * Given an integer n, generate a square matrix filled with elements 
 * from 1 to n2 in spiral order.
 * -------------------------Example----------------------------
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                res[top][j] = num++;
            }
            for (int i = top; i < bottom; i++) {
                res[i][right] = num++;
            }
            for (int j = right; j > left; j--) {
                res[bottom][j] = num++;
            }
            for (int i = bottom; i > top; i--) {
                res[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        
        if (n % 2 != 0) res[n / 2][n / 2] = num;
        return res;
    }
}
// Time complexity: O(n^2)