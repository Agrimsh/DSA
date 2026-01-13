class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                 ans=Math.max(ans,helper(matrix,i,j,-1,dp));
            }
        }
        return ans;
        
    }
    public int helper(int matrix[][],int i,int j,int prev,int dp[][]){
        
         if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=helper(matrix,i+1,j,matrix[i][j],dp);
        int up=helper(matrix,i-1,j,matrix[i][j],dp);
        int left=helper(matrix,i,j+1,matrix[i][j],dp);
        int right= helper(matrix,i,j-1,matrix[i][j],dp);
        return dp[i][j]=1+Math.max(up,Math.max(down,Math.max(left,right)));

    }
}