/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return 
 * its index, otherwise return -1.
 * You may assume NO DUPLICATE exists in the array.
 */

// Method 1: Iterative
public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) return mid;
            
            if (A[left] <= A[mid]) {        // Note: '=' here!!!
                if (A[left] <= target && target < A[mid])
                    right = mid - 1;
                else 
                    left = mid + 1;
            } else if (A[left] > A[mid]) { 
                if (A[mid] < target && target <= A[right])
                    left = mid + 1;
                else 
                    right = mid - 1;
            } 
        }
        
        return -1;
    }
}
// Time complexity: O(N)

// Method 2: Recursive
public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        return find(A, target, 0, A.length - 1);
    }
    
    public int find(int[] A, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        if (A[mid] == target) return mid;
        
        if (A[left] <= A[mid]) {            // Note: '=' here!!!
            if (A[left] <= target && target < A[mid]) {
                return find(A, target, left, mid - 1);
            } else {
                return find(A, target, mid + 1, right);
            }
        } else {
            if (A[mid] < target && target <= A[right]) {
                return find(A, target, mid + 1, right);
            } else {
                return find(A, target, left, mid - 1);
            }
        }
    }
}
// Time complexity: O(log N)

// Method 3: Recursive (Slower)
public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        return find(A, target, 0, A.length - 1);
    }
    
    public int find(int[] A, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        if (A[mid] == target) return mid;
        
        int leftResult = find(A, target, left, mid - 1);
        if (leftResult != -1) return leftResult;
        else return find(A, target, mid + 1, right);
    }
}
// Time complexity: O(N)