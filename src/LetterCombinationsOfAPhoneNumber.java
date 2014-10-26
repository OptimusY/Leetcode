public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuffer sb = new StringBuffer();
        rec(digits, result, sb, dict);
        return result;
    }
    
    public void rec(String digits, List<String> result,
                         StringBuffer sb, String[] dict) {
        // Note: base case is digits.length() == 0, since digits will be
        //       updated and its length will be decreased!!
        if (digits.length() == 0) {     
            result.add(sb.toString());
            return ;
        }
        
        String letters = dict[digits.charAt(0) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            String remain = digits.substring(1);
            rec(remain, result, sb, dict);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// Time complexity: O(2 ^ N)