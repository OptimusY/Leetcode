/**
 * Given an unsorted array of integers, find the length of 
 * the longest consecutive elements sequence.
 * ----Example----
 * Given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence 
 * is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */

// Note: Use Hashtable || HashSet 的空间换时间的题！

// Method 1: Consider more on Time
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length <= 1) return num.length;
        
        HashSet<Integer> set = new HashSet<Integer>();
        int length = 0, max = 0;
        for (int i : num) set.add(i);
        
        for (int j : num) {
            if (set.contains(j)) {
                length = 1;
                set.remove(j);
                int temp = j - 1;
                while (set.contains(temp)) {
                    set.remove(temp);
                    length++;
                    temp--;
                }
                
                temp = j + 1;
                while (set.contains(temp)) {
                    set.remove(temp);
                    length++;
                    temp++;
                }
                
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

// Method 2: Consider more on space:
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) return 0;
        
        java.util.Arrays.sort(num);
        int max = 1, len = 1;
        for (int i = 1; i < num.length; i++) {
            len = 1;
            while (i < num.length && (num[i] == num[i - 1] || num[i] == num[i - 1] + 1)) {
                if (num[i] == num[i - 1] + 1) len++;
                i++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
// Time complexity: O(N * log(N));
// Space complexity: constant