class Solution {
    public int uniquePaths(int m, int n) {
        int [][]grid=new int[m][n];
        int dp[][]=new int[m][n];
        for (int r[]:dp){
            Arrays.fill(r,-1);
        }
       return helper(0,0,m,n,grid,dp);
    }
    public int helper(int i,int j,int m,int n,int grid[][],int dp[][]){
        if(i==m || j==n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=helper(i+1,j,m,n,grid , dp);
        int right=helper(i,j+1,m,n,grid,dp);
        return dp[i][j]=down+right;
    }
}