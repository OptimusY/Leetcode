/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * ---------------------------------Example--------------------------------
 * Given k = 3,  Return [1,3,3,1].
 * ----------------------------------Note----------------------------------
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) return result;
        
        List<Integer> prev = new ArrayList<Integer>();
        result.add(1);
        
        for (int i = 0; i <= rowIndex; i++) {
            prev = result;
            result = new ArrayList<Integer>();
            result.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    result.add(1);
                } else {
                    result.add(prev.get(j - 1) + prev.get(j));
                }
            }
        }
        
        return result;
    }
}
// Time complexity: O(n ^ 2)