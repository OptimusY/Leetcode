/**
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the largest sum.
 */

// Method 1: Brute Force
public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            sum = sum >= 0 ? (sum + A[i]) : A[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
// Time complexity: O(n)

// Method 2: Divide and Conquer
// Case 1: Entire subarray with the max is in A[left, mid - 1]
// Case 2: Entire subarray with the max is in A[mid + 1, right]
// Case 3: Subarray with the max across the mid
public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        return maxSub(A, 0, A.length - 1, max);
    }
    
    public int maxSub(int[] A, int left, int right, int maxV) {
        if (left > right) return Integer.MIN_VALUE;
        
        int mid = left + (right - left) / 2;
        int maxL = maxSub(A, left, mid - 1, maxV);
        int maxR = maxSub(A, mid + 1, right, maxV);
        maxV = Math.max(maxV, maxL);
        maxV = Math.max(maxV, maxR);
        
        int sum = 0; 
        int maxLToM = 0;
        for (int i = mid - 1; i >= left; i--) {
            sum += A[i];
            if (sum > maxLToM) {
                maxLToM = sum;
            }
        }
        
        sum = 0;
        int maxMToR = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += A[i];
            if (sum > maxMToR) {
                maxMToR = sum;
            }
        }
        
        return Math.max(maxLToM + maxMToR + A[mid], maxV);
    }
}