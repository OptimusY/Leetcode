/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */

public class Solution {
    public String reverseWords(String s) {
        if (s == null) return "";
        if (s.trim().isEmpty()) return "";
        
        s = s.trim();
        String[] temp = s.split(" ");
        String result = "";
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = temp[i].trim();
            if (!temp[i].isEmpty()) {
                if (i != 0) result += temp[i] + " ";
                else result += temp[i];
            }
        }
        
        return result;
    }
}
// Time complexity: O(n)