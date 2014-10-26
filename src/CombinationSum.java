/**
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * ----------------------------Note-----------------------------
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending 
 * order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * ---------------------------Example---------------------------
 * given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length == 0) return result;
        
        java.util.Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        rec(candidates, target, result, list, 0);
        return result;
    }
    
    public void rec(int[] arr, int target, List<List<Integer>> result, 
                            List<Integer> list, int index) {
        if (target < 0) return ;
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return ;
        }
        
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            rec(arr, target - arr[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }
}
// Time complexity: O(2 ^ N)