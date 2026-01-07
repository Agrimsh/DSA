class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][2][3];
        for(int dp2[][]:dp){
            for(int d[]:dp2){
                Arrays.fill(d,-1);
            }
        }
       
        return solve (prices,0,1,2,dp);
        
    }
    public int solve(int prices[],int i,int flag,int limit,int dp[][][]){
        int ans=0;
        if(limit==0){
            return 0;
        }
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][flag][limit]!=-1){
            return dp[i][flag][limit];
        }
        if(flag==1){
        int buy=-prices[i]+solve(prices,i+1,0,limit,dp);
        int skip=solve(prices,i+1,1,limit,dp);
         dp[i][flag][limit]= Math.max(buy,skip);
        }
        else{

        int sell=prices[i]+solve(prices,i+1,1,limit-1,dp);
        int skip=solve(prices,i+1,0,limit,dp);
         dp[i][flag][limit]=Math.max(sell,skip);
        }
        return dp[i][flag][limit];

    }
}
