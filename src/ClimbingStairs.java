/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */

// Method 1: DP
public class Solution {
    public int climbStairs(int n) {  
        if (n <= 0) return 0;
        
        int[] result = new int[n + 5];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        return climbStairs(n, result);
    }  
    
    public int climbStairs(int n, int[] result) {
        if (result[n] == 0) {
            result[n] = climbStairs(n - 1, result) + climbStairs(n - 2, result);
        }
        return result[n];
    }
}
// Time complexity: O(n)

// Method 2: Iterative
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int prev0 = 1;
        int prev1 = 2;
        int result = 0;
        
        for (int i = 3; i <= n; i++) {
            result = prev0  + prev1;
            prev0 = prev1;
            prev1 = result;
        }
        
        return result;
    }
}
// Time complexity: O(n)