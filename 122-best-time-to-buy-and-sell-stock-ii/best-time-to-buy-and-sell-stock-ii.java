class Solution {
    public int maxProfit(int[] prices) {
        int [][]dp=new int [prices.length][2];
         for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve (prices,0,1,dp);
        
    }
    public int solve(int prices[],int i,int flag ,int dp[][]){
        int ans=0;
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }
        if(flag==1){
        int buy=-prices[i]+solve(prices,i+1,0,dp);
        int skip=solve(prices,i+1,1,dp);
         dp[i][flag]= Math.max(buy,skip);
        }
        else{

        int sell=prices[i]+solve(prices,i+1,1,dp);
        int skip=solve(prices,i+1,0,dp);
         dp[i][flag]=Math.max(sell,skip);
        }
        return dp[i][flag];

    }
}