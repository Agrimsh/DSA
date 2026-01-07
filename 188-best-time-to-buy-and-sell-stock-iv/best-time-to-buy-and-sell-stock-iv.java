class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k+2];
        for (int dp2 [][]: dp) {
            for (int d[] : dp2) {
                Arrays.fill(d, -1);
            }
        }
        return solve(prices, 0, 1, k, dp);

    }

    public int solve(int prices[], int i, int flag, int k, int dp[][][]) {
        
        if (i >= prices.length||k==0) {
            return 0;
        }
        if(dp[i][flag][k]!=-1){
            return dp[i][flag][k];
        }
        if (flag == 1) {
            int buy = -prices[i] + solve(prices, i + 1, 0, k, dp);
            int skip = solve(prices, i + 1, 1, k, dp);
            dp[i][flag][k] = Math.max(buy, skip);
        } else {

            int sell = prices[i] + solve(prices, i + 1, 1, k - 1, dp);
            int skip = solve(prices, i + 1, 0, k, dp);
            dp[i][flag][k]= Math.max(sell, skip);
        }
        return dp[i][flag][k];

    }
}
