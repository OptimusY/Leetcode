/**
 * Implement pow(x, n).
 */

// Method 1: Iterative
public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        
        boolean flag = false;
        if (n < 0) {
            if (x == 0) return 0;
            flag = true;
            n = 0 - n;
        }
        
        double result = 1.0;
        double temp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * temp;
            }
            temp *= temp;
            n = n / 2;
        }
        
        return flag ? 1.0 / result : result;
    }
}

// Time complexity: O(log N)


// Method 2: Recursion
public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        
        boolean flag = false;
        if (n < 0) {
            if (x == 0) return 0;
            flag = true;
            n = 0 - n;
        }
        
        double temp = pow(x, n / 2);
        double result = 1.0;
        if (n % 2 == 1) {
            result = temp * temp * x;
        } else {
            result = temp * temp;
        }
        
        return flag ? 1.0 / result : result;
    }
}

// Time complexity: O(log N)