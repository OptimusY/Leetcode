/**
 * Given a sorted array, remove the duplicates in place such that 
 * each element appears only once and return the new length.
 * Do not allocate extra space for another array, you must 
 * do this in place with constant memory.
 * ------Example------
 * Given input array A = [1,1,2], Your function should return 
 * length = 2, and A is now [1,2].
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) return A.length;
        
        int i = 0;
        for (int j = 1; j < A.length; j++) {
            if (A[j] != A[i]) {
                A[i + 1] = A[j];
                i++;
            }
        }
        
        return i + 1;
    }
}