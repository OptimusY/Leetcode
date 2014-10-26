/**
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.
 * The digits are stored such that the most significant digit is 
 * at the head of the list.
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        
        int carry = 1;
        boolean flag = false;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp >= 10 ? 1 : 0;
            if (i == 0 && carry == 1) {
                flag = true;
            }
        }
        
        if (flag) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newArr[i + 1] = digits[i];
            }
            return newArr;
        }
        
        return digits;
    }
}