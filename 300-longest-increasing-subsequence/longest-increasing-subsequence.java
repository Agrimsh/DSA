class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int [nums.length][nums.length];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return helper(nums,-1,0,dp);
        
    }
    public int helper(int nums[],int prev,int i,int dp[][]){
        int take=0;
        if(i>=nums.length){
            return 0;
        }
        if(dp[prev+1][i]!=-1){
            return dp[prev+1][i];
        }
        int not_take=helper(nums,prev,i+1,dp);
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+helper(nums,i,i+1,dp);
        }
        return dp[prev+1][i]=Math.max(take,not_take);

    }
}