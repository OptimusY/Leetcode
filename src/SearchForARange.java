/**
 * Given a sorted array of integers, find the starting and ending position
 * of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n)
 * If the target is not found in the array, return [-1, -1].
 * -------------------------Example----------------------------
 * Given [5, 7, 7, 8, 8, 10] and target value 8    --->   return [3, 4].
 */

// Method 1: Two Times Binary Search, Iterative
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) return new int[] {-1, -1};
        int[] result = new int[2];
        result[0] = searchLeft(A, target);
        result[1] = searchRight(A, target);
        return result;
    }
    
    public int searchLeft(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                if (mid - 1 >= 0 && A[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return  -1;
    }
    
    public int searchRight(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left ) / 2;
            if (A[mid] == target) {
                if (mid + 1 < A.length && A[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
// Time complexity: O(log N)


// Method 2: Two Times Binary Search, Recursive
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) return new int[] {-1, -1};
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        rec(A, target, 0, A.length - 1, result);
        if (result[0] == Integer.MAX_VALUE) return new int[] {-1, -1};
        else return result;
    }
    
    public void rec(int[] A, int target, int left, int right, int[] result) {
        if (left > right) return ;
        
        int mid = left + (right - left) / 2;
        if (A[mid] == target) {
            result[0] = Math.min(result[0], mid);
            result[1] = Math.max(result[1], mid);
            rec(A, target, left, mid - 1, result);
            rec(A, target, mid + 1, right, result);
        } else if (A[mid] > target) {
            rec(A, target, left, mid - 1, result);
        } else {
            rec(A, target, mid + 1, right, result);
        }
    }
}
// Time complexity: O(log N), but has extra space


// Method 3: One Time Binary Search, Iterative
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) return new int[] {-1, -1};
        
        int left = 0, right = A.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                index = mid;
                break;
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if (index == -1) {
            return new int[] {-1, -1};
        } else {
            int i = index, j = index;
            while (i >= 0 && A[i] == target) i--;
            while (j < A.length && A[j] == target) j++;
            return new int[] {i + 1, j - 1};
        }
    }
}
// Time complexity: Average: O(log N);
//                  Worst  : O(N)