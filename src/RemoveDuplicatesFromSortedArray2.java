
/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * --------------------Example-------------------
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */

// Method 1: Optimal
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length < 3) return A.length;
        
        int i = 0, cnt = 0;
        for (int j = 1; j < A.length; j++) {
            if (A[j] == A[i]) {
                if (cnt == 0) {
                    cnt++;
                    i++;
                    A[i] = A[j];
                } 
                cnt++;
            } else {
                i++;
                A[i] = A[j];
                cnt = 0;
            }
        }
        return i + 1;
    }
}

// Method 2: Use an extra HashMap
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length < 3) return A.length;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0, j = 0;
        for (i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
                A[j] = A[i];
                j++;
            } else {
                if (map.get(A[i]) == 1) {
                    map.put(A[i], 2);
                    A[j] = A[i];
                    j++;
                }
            }
        }
        
        return j;
    }
}
// Time complexity: O(n)