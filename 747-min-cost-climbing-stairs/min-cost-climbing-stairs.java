class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,0,dp), helper(cost,1,dp));    
    }
     int helper(int []cost,int idx,int dp[]){
        if(idx >= cost.length){
            return 0;
        }
        if(idx == cost.length -1 ){
         return cost[idx];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int onestep=cost[idx] + helper(cost,idx+1,dp);
        int twostep=cost[idx] + helper(cost,idx+2,dp);
        return dp[idx]=Math.min(onestep,twostep);
    }
    
}