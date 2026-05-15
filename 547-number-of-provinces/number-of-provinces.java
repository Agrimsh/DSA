class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count =0;
        boolean vis[]=new boolean[isConnected.length+1];
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                bfs(i,isConnected,vis);
                count++;
            }
        }
        return count;
        
    }
    public void bfs(int src,int[][] isConnected,boolean vis[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty()){
            int curr=q.poll();

            for(int j=0;j<isConnected.length;j++){
                if(isConnected[curr][j]==1 && vis[j]==false){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }  
    }
}