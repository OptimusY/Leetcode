/**
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

/* Similar: Combinations*/

// Method 1:
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0) return result;
        
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        rec(num, list, result, visited);
        return result;
    }
    
    public void rec(int[] num, List<Integer> list, 
                        List<List<Integer>> result, boolean[] visited) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return ;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(num[i]);
                rec(num, list, result, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
// Time complexity: O(n!)


// Method 2:
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0)    return result;
        List<Integer> list = new ArrayList<Integer>();
        permutation(num, list, result);
        return result;
    }
    
    public void permutation(int[] num, List<Integer> list, List<List<Integer>> result) {
        if (num.length == 0) {
            result.add(new ArrayList<Integer>(list));  // Note: create a new list and copy elements from "list" into it
            return ;
        } else {
            for (int i = 0; i < num.length; i++) {
                int[] newArr = new int[num.length - 1];   
                copyArray(num, 0, newArr, 0, i);
                copyArray(num, i + 1, newArr, i, num.length - i - 1);
                
                list.add(num[i]);
                permutation(newArr, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public void copyArray(int[] num, int i, int[] newArr, int j, int length) {
        for (int k = 0; k < length; k++) {
            newArr[j + k] = num[i + k];
        }
    }
}
// Time complexity: O(n!)