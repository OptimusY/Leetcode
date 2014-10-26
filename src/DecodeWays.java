/**
 * A message containing letters from A-Z is being encoded to numbers
 * using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total
 * number of ways to decode it.
 * --------------------------------Example---------------------------
 * Given encoded message "12", it can be decoded as "AB" (1, 2) or "L" (12)
 * The number of ways decoding "12" is 2. 
 */

// Method 1: Iterative
public class Solution {
    public int numDecodings(String s) {  
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return count(s.charAt(0));
        
        int prev0 = count(s.charAt(0));
        int prev1 = count(s.charAt(0)) * count(s.charAt(1)) + 
                    count(s.charAt(0), s.charAt(1));
        int temp = 0;
        for (int i = 2; i < s.length(); i++) {
            if (count(s.charAt(i)) == 1) temp = prev1;
            if (count(s.charAt(i - 1), s.charAt(i)) == 1) temp += prev0;
            prev0 = prev1;
            prev1 = temp;
            temp = 0;
        }
        return prev1;
    }
    
    public int count(char ch) {
        int val = ch - '0';
        boolean b = val >= 1 && val <= 9;
        return b ? 1 : 0;
    }
    
    public int count(char ch0, char ch1) {
        int val0 = ch0 - '0';
        int val1 = ch1 - '0';
        boolean b = (val0 == 1 && (val1 >= 0 && val1 <= 9)) ||
                    (val0 == 2 && (val1 >= 0 && val1 <= 6));
        return b ? 1 : 0;
    }
}
// Time complexity: O(N)


// Method 2: DP
public class Solution {
    public int numDecodings(String s) {  
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return count(s.charAt(0));
        
        int[] result = new int[s.length() + 5];
        result[0] = count(s.charAt(0));
        result[1] = count(s.charAt(0)) * count(s.charAt(1)) + 
                        count(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (count(s.charAt(i)) == 1) result[i] = result[i - 1];
            if (count(s.charAt(i - 1), s.charAt(i)) == 1) {
                result[i] += result[i - 2];
            }
        }
        return result[s.length() - 1];
    }
    
    public int count(char ch) {
        int val = ch - '0';
        boolean b = val >= 1 && val <= 9;
        return b ? 1 : 0;
    }
    
    public int count(char ch0, char ch1) {
        int val0 = ch0 - '0';
        int val1 = ch1 - '0';
        boolean b = (val0 == 1 && (val1 >= 0 && val1 <= 9)) ||
                    (val0 == 2 && (val1 >= 0 && val1 <= 6));
        return b ? 1 : 0;
    }
}
// Time complexity: O(N)