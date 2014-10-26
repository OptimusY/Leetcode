/**
 * Given a collection of integers that might contain duplicates, S,
 * return all possible subsets.
 * -----------------------Note--------------------------
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * -----------------------Example-----------------------
 * If S = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */

// Method 1: DFS Pattern
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (num.length == 0) return result;
        
        java.util.Arrays.sort(num);
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);
        rec(num, result, list, 0);
        return result;
    }
    
    public void rec(int[] num, List<List<Integer>> result, 
                    List<Integer> list, int index) {
        if (index == num.length) return ;
        
        for (int i = index; i < num.length; i++) {
            list.add(num[i]);
            result.add(new ArrayList<Integer>(list));
            rec(num, result, list, i + 1);
            list.remove(list.size() - 1);
            while (i < num.length - 1 && num[i] == num[i + 1]) i++;
        }
    }
}
// Time complexity: O(2 ^ N)


// Method 2: Traditional like CC
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num.length == 0) return new ArrayList<List<Integer>>();
        java.util.Arrays.sort(num);
        return rec(num, 0);
    }
    
    public List<List<Integer>> rec(int[] num, int index) {
        List<List<Integer>> result = null;
        if (index == num.length) {
            result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        } else {
            result = rec(num, index + 1);
            int item = num[index];
            List<List<Integer>> buff = new ArrayList<List<Integer>>();
            for (List<Integer> set : result) {
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(set); 
                list.add(0, item);
                if (!result.contains(list)) buff.add(list);
            }
            result.addAll(buff);
            return result;
        }
    }
}
// Time complexity: O(2 ^ N)