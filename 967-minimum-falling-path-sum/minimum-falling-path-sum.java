class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int min =Integer.MAX_VALUE;
        int[][] dp = new int[row][col];
        for(int[] rows : dp) {
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        for(int i=0;i<col;i++){
            min=Math.min(min,min(0,i,row,col,matrix,dp));

        }
        return min;   
    }
    public int min(int i,int j,int row,int col, int matrix[][],int dp[][]){
        if(j<0 || j>=col){
            return Integer.MAX_VALUE;
        }

        if(i==row - 1) return matrix[i][j];
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left=min(i+1,j-1,row,col,matrix,dp);
        int right=min(i+1,j+1,row,col,matrix,dp);
        int down=min(i+1,j,row,col,matrix,dp);

        int min1=Math.min(left,Math.min(right,down));
        return dp[i][j]= matrix[i][j]+min1;
    }
}