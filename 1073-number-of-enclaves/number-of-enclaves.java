class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && grid[i][j]==1){
                    dfs(i,j,grid);
                }
                if(i==m-1 && grid[i][j]==1){
                    dfs(i,j,grid);
                }
                if(j==0 && grid[i][j]==1){
                    dfs(i,j,grid);
                }
                if(j==n-1 && grid[i][j]==1){
                    dfs(i,j,grid);
                }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
        
    }

 public void dfs(int i,int j,int grid[][]){
         if (i < 0 || j < 0 || i >=grid.length || j >=grid[0].length||grid[i][j]==0){
        return;
        }
        grid[i][j]=0;

        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}