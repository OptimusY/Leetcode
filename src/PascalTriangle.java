/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) return result;
        
        ArrayList<Integer> curr = new ArrayList<Integer>();
        ArrayList<Integer> prev = new ArrayList<Integer>();
        curr.add(1);
        result.add(curr);
        
        for (int i = 1; i < numRows; i++) {
            prev = curr;
            curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 1; j <= i; j++) {  // i is essentially prev.size()
                if (j == i) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }
            result.add(curr);
        }
        
        return result;
    }
}
// Time complexity: O(n ^ 2)