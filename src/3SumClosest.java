/**
 * Given an array S of n integers, find three integers in S such that
 * the sum is closest to a given number, target. Return the sum of the
 * three integers. 
 * You may assume that each input would have exactly one solution.
 * ----------------------------Example-----------------------------
 * Given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num.length == 0) return Integer.MAX_VALUE;
        
        java.util.Arrays.sort(num);       
        int diff = Integer.MAX_VALUE;
        int result = 0;
        
        for (int i = 0; i <= num.length - 3; i++) {
            int beg = i + 1, end = num.length - 1;
            while (beg < end) {
                int sum = num[i] + num[beg] + num[end];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    result = sum;
                }
                
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    beg++;
                } else {
                    end--;   
                }                    
            }
        }
        return result;
    }
}
// Time complexity: O(N ^ 2)