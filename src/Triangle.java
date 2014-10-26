/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * ------------------------------Example-----------------------------
 * Given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11)
 * --------------------------------Note------------------------------
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */


// Method 1: Optimal, without using extra space
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        
        int m = triangle.size();
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j);
                int left = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, val + Math.min(left, right));
            }
        }
        return triangle.get(0).get(0);
    }          
}
// Time complexity: O(n ^ 2)


// Method 2: Less optimal, use O(n ^ 2) extra space
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            result[m - 1][i] = triangle.get(m - 1).get(i);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j);
                result[i][j] = val + Math.min(result[i + 1][j], result[i + 1][j + 1]);
            }
        }
        
        return result[0][0];
    }          
}
// Time complexity: O(n ^ 2)


// Method 3: Similar to Unique Path, Min Path Sum
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] result = new int[m][n];
        
        result[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            result[i][0] = triangle.get(i).get(0) + result[i - 1][0];
            result[i][i] = triangle.get(i).get(i) + result[i - 1][i - 1];
        }
        
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                result[i][j] = Math.min(result[i - 1][j - 1], result[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, result[m - 1][i]);
        }
        
        return min;
    }          
}
// Time complexity: O(n ^ 2)