class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return helper(nums,0,-1,dp);
    }

    public int helper(int nums[],int i, int back,int dp[][]){
        int take=0;
        if(i==nums.length){
            return 0;
        }
        if(dp[i][back+1]!=-1){
            return dp[i][back+1];
        }
        if(back==-1||nums[back]<nums[i]){
        take = 1+helper(nums,i+1,i,dp);
        }
        int not_take=helper(nums,i+1,back,dp);
        return dp[i][back+1]=Math.max(take,not_take);
    }
}