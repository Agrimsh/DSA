class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int [n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
       return min(0,0,triangle,dp);    
    }
    public int min(int i,int j,List<List<Integer>> triangle,int dp[][]){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }
        int left=min(i+1,j,triangle,dp);
        int right=min(i+1,j+1,triangle,dp);
        int min=Math.min(left,right);
        return dp[i][j]=min+triangle.get(i).get(j);
    }
}