class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = n;
            int num = 1;
            while (i >= num * num) {
                min = Math.min(dp[i - num * num] + 1, min);
                num++;
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
