/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which
 * gives the sum of zero.
 * --------------------------------Note---------------------------------
 * Elements in a triplet (a,b,c) must be in non-descending order.
 * The solution set must not contain duplicate triplets.
 * -------------------------------Example-------------------------------
 * Given array S = {-1 0 1 2 -1 -4},
 * A solution set is: ((-1, 0, 1), (-1, -1, 2))
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0) return result;
        
        java.util.Arrays.sort(num);
        for (int i = 0; i <= num.length - 3; i++) {
            int beg = i + 1, end = num.length - 1;
            while (beg < end) {
                int sum = num[i] + num[beg] + num[end];
                if (sum == 0) {
                    // Note: Create the list at here!!
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[beg]);
                    list.add(num[end]);
                    result.add(list);
                    beg++;
                    end--;
                    while (beg < end && num[beg] == num[beg - 1]) beg++;
                    while (end > beg && num[end] == num[end + 1]) end--;
                } else if (sum < 0) {
                    beg++;
                } else {
                    end--;
                }
            }
            while (i <= num.length - 3 && num[i] == num[i + 1]) i++;
        }
        return result;
    }
}
// Time complexity: O(n ^ 2)