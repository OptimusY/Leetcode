/**
 * Given a sorted array and a target value, return the index 
 * if the target is found. If not, return the index where it 
 * would be if it were inserted in order.
 * --NOTE--
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */

// Method 1: Binary search enhance
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        
        int beg = 0, end = A.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (A[mid] == target) { return mid; }
            else if (A[mid] < target) { beg = mid + 1; }
            else { end = mid - 1; }
        }
        return beg;
    }
}
// Time complexity: O(log(N))


// Method 2: Brute force
public class Solution {
    public int searchInsert(int[] A, int target) {
        int result = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            } else if (A[i] < target) {
                result = i + 1;
            } else {
                return result;
            }
        }
        
        return A.length;    // handle the last one
    }
}
// Time complexity: O(n)