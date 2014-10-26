/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * ----Note----
 * A word is defined as a character sequence consists of non-space characters only.
 * ----Example----
 * Given s = "Hello World", return 5.
 */

// Method 1: Without trim()
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        
        int post = s.length() - 1;
        int length = 0;
        while (post >= 0 && s.charAt(post) == ' ') post--;
        if (post < 0) return 0;
        
        while (post >= 0 && s.charAt(post) != ' ') {
            post--;
            length++;
        }
        
        return length;
    }
}
// Time complexity: O(n)

// Method 2: With trim()
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        
        int post = s.length() - 1;
        int length = 0;
        while (post >= 0 && s.charAt(post) != ' ') {
            post--;
            length++;
        }
        
        return length;
    }
}
// Time complexity: O(n)