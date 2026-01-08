class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(int i=nums.length-1;i>=0;i--){
            for (int prev=i-1;prev>=-1;prev--){
                int select=0;
                if(prev==-1||nums[prev]<nums[i]){
                    select=1+dp[i+1][i+1];
                }
                int skip=dp[i+1][prev+1];
                dp[i][prev+1]=Math.max(select,skip);
            }
        }
        return dp[0][0];
      
    }
}