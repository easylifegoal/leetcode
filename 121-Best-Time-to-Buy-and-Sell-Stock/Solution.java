class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int temp = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            temp = prices[i] - minPrice;
            if (temp > maxProfit) maxProfit = temp;
        }

        return maxProfit;
    }
}
