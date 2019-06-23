class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
           if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
        }

        return maxProfit;
    }

}

class Solution {
    public int maxProfit(int[] prices) {
        return getProfit(prices, 0);
    }

    public int getProfit(int[] prices, int start) {
        if (start >= prices.length) return 0;

        int max = 0;
        for (; start < prices.length; start++) {
            int maxProfit = 0;
            int profit = 0;
            for(int i = start + 1; i < prices.length; i++) {
                if (prices[i] > prices[start]) {
                    profit = getProfit(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit) maxProfit = profit;
                }

            }
            if (maxProfit > max) max = maxProfit;
        }

        return max;
    }

}
