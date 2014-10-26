/**
 * Given an integer, convert it to a roman numeral
 * Input is guaranteed to be within the range from 1 to 3999
 */
public class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        
        int[] arabics = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String roman = "";
        
        for (int i = 0; i < arabics.length; i++) {
            while (num >= arabics[i]) {
                num -= arabics[i];
                roman += romans[i];
            }
        }
        
        return roman;
    }
}
// Time complexity: O(n)