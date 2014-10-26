/**
 * Given two integers n and k, return all possible combinations of 
 * k numbers out of 1 ... n.
 * ----Example----
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */

//---- Similar: Permutations

// Method 1:
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < k) return result;
        
        List<Integer> list = new ArrayList<Integer>();
        rec(n, k, 1, result, list);
        return result;
    }
    
    public void rec(int n, int k, int start, List<List<Integer>> result, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(list));
            return ;
        } else {
            for (int i = start; i <= n - k + 1; i++) {
                list.add(i);
                rec(n, k - 1, i + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
// Time complexity: O(n!)

// Method 2: Similar to Method 1
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        combine(n, k, 1, list, result);
        return result;
    }
    
    public void combine(int n, int k, int beg, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return ;
        } else {
            for (int i = beg; i <= n; i++) {
                list.add(i);
                combine(n, k, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}