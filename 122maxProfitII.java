class Solution {
    //O(n^n) 
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }
    
    private int calculate(int[] prices, int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start<prices.length; start++) {
            int maxProfit = 0;
            for (int i = start +1; i<prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit =calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit)
                        maxProfit = profit;
                }   
            }
            if (max < maxProfit)
                max = maxProfit;
        }
        return max;
    }
}

class Solution {
    // O(n)
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while (i < prices.length-1) {
            while (i < prices.length-1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length-1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}