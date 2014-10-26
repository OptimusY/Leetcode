
// Method 1: Without extra space
public class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = 0 - x;
        }
        
        int result = 0;
        while (x > 0) {
            int val = x % 10;
            result = 10 * result + val;
            x /= 10;
        }
        
        return flag ? 0 - result : result;
    }
}


// Method 2: With extra space and data structure
public class Solution {
    public int reverse(int x) {
        String str = Integer.toString(x);
        StringBuffer sb = new StringBuffer();
        int startIndex = 0;
        
        if (str.charAt(0) == '-') {
            sb.append('-');
            startIndex = 1;
        }
        
        for (int i = str.length() - 1; i >= startIndex; i--) {
            sb.append(str.charAt(i));
        }
        
        return Integer.parseInt(sb.toString());
    }
}
