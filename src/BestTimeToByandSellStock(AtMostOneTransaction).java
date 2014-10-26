/**
 * Say you have an array for which the ith element is the price of a 
 * given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to 
 * find the maximum profit.
 */

// Make two pointers! Keep the max profit and min price updated in the scan
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
}
// Time complexity: O(n)