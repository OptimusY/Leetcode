/**
 * Given n non-negative integers representing an elevation map where the 
 * width of each bar is 1, compute how much water it is able to trap 
 * after raining.
 * ----Example----
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

// Method 1: 1 scan
public class Solution {
    public int trap(int[] A) {
        if (A.length < 0) return 0;
        
        int left = 0, right = A.length - 1;
        int area = 0;
        
        while (left < right) {
            int height = Math.min(A[left], A[right]);
            if (A[left] == height) {
                left++;
                while (left < right && A[left] < height) {
                    area += height - A[left];
                    left++;
                }
            } else {
                right--;
                while (left < right && A[right] < height) {
                    area += height - A[right];
                    right--;
                }
            }
        }
        
        return area;
    }
}
// Time complexity: O(n)


// Method 2: 2 scan
public class Solution {
    public int trap(int[] A) {
        if (A.length <= 1) return 0;
        
        int[] heights = new int[A.length];
        int max = 0;
        int area = 0;
        
        for (int i = 0; i < A.length; i++) {
            heights[i] = max;
            max = Math.max(max, A[i]);
        }
        
        max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            heights[i] = Math.min(max, heights[i]);
            area += heights[i] - A[i] > 0 ? heights[i] - A[i] : 0;
            max = Math.max(A[i], max);
        }
        
        return area;
    }
}
// Time complexity: O(n)