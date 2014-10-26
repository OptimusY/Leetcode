/*
 * Given an array of integers, every element appears 
 * twice except for one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 */

// Method 1: with extra memory
public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], 2);
            } else {
                map.put(A[i], 1);
            }
        }
        for (Integer j : map.keySet()) {
            if (map.get(j) == 1) return j;
        }
        return Integer.MIN_VALUE;
    }
}

// Method 2: without extra memory
public class Solution {
    public int singleNumber(int[] A) {
        int res = A[0];
        for (int i = 1; i < A.length; i++){
            res = res ^ A[i];
        }
        return res;
    }
}
// Use XOR: 
// XOR is a good way, we can use the property that:
// A XOR A = 0, and A XOR B XOR A = B.