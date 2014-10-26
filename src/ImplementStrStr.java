/**
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 */

public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null ||
                needle.length() > haystack.length()) return null;
        
        int j = 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) return haystack.substring(i);
        }
        return null;
    }
}
// Time complexity: O(n ^ 2)