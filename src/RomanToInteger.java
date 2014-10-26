/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * Hint: Traverse the whole roman numeral, if the next one is
 *       smaller than the current one, add the next one;
 *       if the next one is larger than the current one, add
 *       the next one then subtract the current one twice.
 */

public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        
        int[] dict = new int[256];
        dict['I'] = 1;
        dict['V'] = 5;
        dict['X'] = 10;
        dict['L'] = 50;
        dict['C'] = 100;
        dict['D'] = 500;
        dict['M'] = 1000;
        
        char[] roman = s.toCharArray();
        int result = dict[roman[0]];
        
        for (int i = 0; i < roman.length - 1; i++) {
            if (dict[roman[i]] >= dict[roman[i + 1]]) {
                result += dict[roman[i + 1]];
            } else {
                result = result - 2 * dict[roman[i]] + dict[roman[i + 1]];
            }
        }
        
        return result;
    }
}
// Time complexity: O(n)