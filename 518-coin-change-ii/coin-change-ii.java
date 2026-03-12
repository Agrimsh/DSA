class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int [coins.length+1][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }

        return solve(0,amount,coins,dp);   
    }
    static int solve(int i,int amount,int coins[],int dp[][]){
        if(amount==0){
            return 1;
        }
        if(i==coins.length){
            return 0;
        }
        if(coins[i]>amount){
            return solve(i+1,amount,coins,dp);
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=solve(i,amount-coins[i],coins,dp);
        int skip=solve(i+1,amount,coins,dp);
        return dp[i][amount]=take+skip;
    }
    
}