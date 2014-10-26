/**
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        generateParens(n, 0, 0, "", result);
        return result;
    }
    
    public void generateParens(int n, int left, int right, String str, List<String> result) {
        if (left < right) return ;
        
        if (left == n && right == n) {
            result.add(str);
            return ;
        }
        
        if (left == n) {
            generateParens(n, left, right + 1, str + ")", result);
            return ;
        }
        
        generateParens(n, left + 1, right, str + "(", result);
        generateParens(n, left, right + 1, str + ")", result);
    }
}
// Time complexity: O(2 ^ n)