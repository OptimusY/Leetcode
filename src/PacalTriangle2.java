/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * -----------------------Example---------------------
 * Given k = 3,
 * Return [1,3,3,1].
 * -----------------------Note----------------------
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<Integer>();
        List<Integer> prev = new ArrayList<Integer>();
        if (rowIndex < 0) return curr;
        
        curr.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            prev = curr;
            curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }
        }
        
        return curr;
    }
}
// Time complexity: O(n ^ 2)