/**
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * ----------------------------Example------------------------------
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * -----------------------------Note--------------------------------
 * Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * For this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return true;
        
        int beg = 0, end = s.length() - 1;
        while (beg < end) {
            while (beg < end && !Character.isLetterOrDigit(s.charAt(beg))) {
                beg++;
            }
            while (beg < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (beg >= end) return true;
            
            char chBeg = Character.toLowerCase(s.charAt(beg));
            char chEnd = Character.toLowerCase(s.charAt(end));
            if (chBeg != chEnd) return false;
            beg++;
            end--;
        }
        return true;
    }
}
// Time complexity: O(N)