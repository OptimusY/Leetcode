/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */

// Method 1: Iterative
public class Solution {
    public boolean search(int[] A, int target) {
        if (A.length == 0) return false;
        
        int beg = 0, end = A.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (A[mid] == target) return true;
            
            if (A[beg] < A[mid]) {
                if (A[beg] <= target && target < A[mid]) end = mid - 1;
                else beg = mid + 1;
            } else if (A[beg] > A[mid]) { 
                if (A[mid] < target && target <= A[end]) beg = mid + 1;
                else end = mid - 1;
            } else {
                beg++;
            }
        }
        return false;
    }
}
// Time complexity: Average: O(logN) (when elements are unique)
//                  Worst  : O(N)    (when a lot of duplicates)

// Method 2: Recursive
public class Solution {
    public boolean search(int[] A, int target) {
        if (A.length == 0) return false;
        return search(A, target, 0, A.length - 1);
    }
    
    public boolean search(int[] A, int target, int left, int right) {
        if (left > right) return false;
        
        int mid = left + (right - left) / 2;
        if (A[mid] == target) return true;
        
        if (A[left] < A[mid]) {
            if (A[left] <= target && target < A[mid]) {
                return search(A, target, left, mid - 1);
            } else {
                return search(A, target, mid + 1, right);
            }
        } else if (A[left] > A[mid]) {
            if (A[mid] < target && target <= A[right] ) {
                return search(A, target, mid + 1, right);
            } else {
                return search(A, target, left, mid - 1);
            }
        } else {
            if (A[mid] != A[right]) return search(A, target, mid + 1, right);
            else {
                return search(A, target, mid + 1, right) || 
                        search(A, target, left, mid - 1);
            }
        }
    }
}
// Time complexity: Average: O(logN) (when elements are unique)
//                  Worst  : O(N)    (when a lot of duplicates)