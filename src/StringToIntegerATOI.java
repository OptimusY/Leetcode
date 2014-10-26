/**
 * Implement atoi to convert a string to an integer.
 *--- -----------------------------Hint---------------------------------
 * Carefully consider all possible input cases.
 * --------------------------------Notes--------------------------------
 * It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements
 * up front.
 * ---------------------Requirements for atoi---------------------------
 * 1. The function first discards as many whitespace characters as
 * necessary until the first non-whitespace character is found.
 * 2. Then, starting from this character, takes an optional initial plus or
 * minus sign followed by as many numerical digits as possible, and
 * interprets them as a numerical value.
 * 3. The string can contain additional characters after those that form
 * the integral number, which are ignored and have no effect on the
 * behavior of this function.
 * 4. If the first sequence of non-whitespace characters in str is not a
 * valid integer, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 5. If no valid conversion could be performed, a zero value is returned.
 * 6. If the correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class Solution {
    public int atoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        
        long result = 0;
        char sign = '+';
        int pos = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            pos++;
            sign = str.charAt(0);
        }
        
        while (pos < str.length() && Character.isDigit(str.charAt(pos))) {
            result = 10 * result + (str.charAt(pos) - '0');
            pos++;
        }
        
        if (sign == '-') result = 0 - result;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)result;
        }
    }
} 
// Time complexity: O(N)