class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int dis[][]=new int[n][m];
        for(int i[]:dis){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int effort=curr[0];
            int row=curr[1];
            int col=curr[2];

            for(int neigh[]:dir){
                int newrow=row+neigh[0];
                int newcol=col+neigh[1];

                if(newrow>=0 && newcol>=0 && newrow<n &&newcol<m){
                    int absdiff=Math.abs(heights[row][col]-heights[newrow][newcol]);
                    int max=Math.max(effort,absdiff);

                    if(dis[newrow][newcol]>max){
                        dis[newrow][newcol] = max;
                        pq.add(new int[]{max,newrow,newcol});
                    }
                }
            }
        }  
         return dis[n-1][m-1];
    }
}