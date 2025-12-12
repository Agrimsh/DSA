class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1){
            return arr[0];
        }

        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        int x=helper(arr,0,dp,n-1); 
        int dps[]=new int[arr.length];
        Arrays.fill(dps,-1);
         int y=helper(arr,1,dps,n);
        return Math.max(x,y);
    }
    public int helper(int arr[],int idx,int dp[],int n){   //0 to n
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!= -1){
            return dp[idx];
        }
        int firstnum=arr[idx]+helper(arr,idx+2,dp,n);
        int secondnum=helper(arr,idx+1,dp,n);
        dp[idx]=Math.max(firstnum,secondnum);
        return dp[idx];
        
    }
}