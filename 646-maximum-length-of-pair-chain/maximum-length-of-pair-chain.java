class Solution {
    public int findLongestChain(int[][] pairs) {
        int dp[][]=new int [1001][1001];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        return helper(pairs,0,-1,dp);
    }
    public int helper(int pairs[][],int i,int prev,int dp[][]){
        int take=0;
        if(i>=pairs.length){
            return 0;
        }
        if(dp[prev+1][i]!=-1){
            return dp[prev+1][i];
        }
        if(prev==-1 || pairs[prev][1]<pairs[i][0]){
            take=1+helper(pairs,i+1,i,dp);
        }
        int not_take=helper(pairs,i+1,prev,dp);
        return dp[prev+1][i]=Math.max(take,not_take);
    }
}