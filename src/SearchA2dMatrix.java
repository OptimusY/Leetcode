/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * --------------- Example ---------------
 * Consider the following matrix:
 *  [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 *  ]
 * Given target = 3, return true.
 */

// Method 1: 
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
// Time complexity: O(m + n), m is the num of rows, n is the num of cols

// Method 2: Binary search * m times, where m is the num of row of matrix
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        for (int i = 0; i < matrix.length; i++) {
            if (search(matrix[i], target)) return true;
        }
        
        return false;
    }
    
    public boolean search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else  if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
// Time complexity: O(m * log(n))