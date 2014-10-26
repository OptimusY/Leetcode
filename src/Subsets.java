/**
 * Given a set of distinct integers, S, return all possible subsets.
 * --------------------Note--------------------
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * ------------------Example-------------------
 * If S = [1,2,3], a solution is:
 * 
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) return null;
        java.util.Arrays.sort(S);
        return findSubsets(S, 0);
    }
    
    public List<List<Integer>> findSubsets(int[] A, int index) {
        List<List<Integer>> result = null;
        if (index == A.length) {
            result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        } else {
            result = findSubsets(A, index + 1);
            int item = A[index];
            List<List<Integer>> buff = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                List<Integer> set = new ArrayList<Integer>();
                set.addAll(list);
                set.add(0, item);
                buff.add(set);
            }
            result.addAll(buff);
            return result;
        }
    }
}
// Time complexity: O(2 ^ n)