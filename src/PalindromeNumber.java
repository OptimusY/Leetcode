/**
 * Determine whether an integer is a palindrome. 
 * Do this without extra space.
 */


// Method 1: Iterative
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int div = 1;
        while (x / div >= 10) div *= 10;
        
        while (div >= 10 && x / div == x % 10) {
            x = (x - x / div * div) / 10;
            div /= 100;
        }
        
        return div >= 10 ? false : true;
    }
}
// Time complexity: O(logN)


// Method 2: Recursive
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        
        int numDigits = 0;
        int rest = x;
        while (rest > 0) {
            rest = rest / 10;
            numDigits++;
        }
        
        int div = (int) Math.pow(10, numDigits - 1);
        
        return isPal(x, div);
    }
    
    public boolean isPal(int x, int div) {
        if (x < 0) return false;
        if (x < 10 && div <= 1) return true;
        
        int quotient = x / div;
        int remain = x % 10;
        if (quotient != remain) return false;
        
        return isPal((x - quotient * div) / 10, div / 100);
    }
}
// Time complexity: O(log N)