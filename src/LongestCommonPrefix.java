public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        String str = strs[0], result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i) return strs[j];
                if (strs[j].charAt(i) != ch) return result;
            }
            result += ch;
        }
        return result;
    }
}
// Time complexity: O(M * N), where
// M is the longest length of the prefix, N is the array's length