/**
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.
 * Each value in the array is your maximum jump length at that position
 * Determine if you are able to reach the last index.
 * --------------------------Example---------------------------
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

// DP
public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 0 || A.length == 1) return true;
        
        int dist = 0;
        for (int i = 0; i < A.length; i++) {
            if (i <= dist) {
                dist = Math.max(A[i] + i, dist);
                if (dist >= A.length - 1) return true;
            }
        }
        
        return false;
    }
}
// Time complexity: O(N)