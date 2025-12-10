class Solution {
    public int rob(int[] arr) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr,arr.length-1,dp);   
    }
    public int helper(int arr[],int idx,int dp[]){
        if(idx<0){
            return 0;
        }
        if(dp[idx]!= -1){
            return dp[idx];
        }
        int firstnum=arr[idx]+helper(arr,idx-2,dp);// n-1 to 0
        int secondnum=helper(arr,idx-1,dp);
        dp[idx]=Math.max(firstnum,secondnum);
        return dp[idx];
    }
}

/*class Solution {
    public int rob(int[] arr) {
        int dp[]=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return helper(arr,0,dp);   
    }
    public int helper(int arr[],int idx,int dp[]){   //0 to n
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!= -1){
            return dp[idx];
        }
        int firstnum=arr[idx]+helper(arr,idx+2,dp);
        int secondnum=helper(arr,idx+1,dp);
        dp[idx]=Math.max(firstnum,secondnum);
        return dp[idx];
    }
}*/
