class Solution {
    public int orangesRotting(int[][] grid) {
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int m=grid.length;
        int n=grid[0].length;
        int freshoranges=0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshoranges++;
                }
            }
        }
        if(freshoranges==0){
            return 0;
        }
        int minutes=0;
        while(!q.isEmpty()){
            int x=q.size();
            while(x-- > 0){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];

                for(int d[]:dir){
                    int newr=r+d[0];
                    int newc=c+d[1];

                    if(newr>=0 && newr<m && newc>=0 && newc<n &&grid[newr][newc]==1){
                        grid[newr][newc]=2;
                        q.add(new int[]{newr,newc});
                        freshoranges--;
                    }
                }
            }
            minutes++;
        }
        if(freshoranges==0){
            return minutes-1;
        }
        else{
            return -1;
        }
    }
}