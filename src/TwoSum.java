/**
 * Given an array of integers, find two numbers such that
 * they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 * ------------------------------Example-------------------------------
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) return new int[] {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i + 1);
            } else {
                result[0] = map.get(target - numbers[i]);
                result[1] = i + 1;
                break;
            }
        }
        
        return result;
    }
}
// Time complexity: O(N)