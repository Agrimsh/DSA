class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean visited[]=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                count++;
            }

        }
        return count;
        
    }
    public void dfs(int isconnected[][],int src,boolean visited[]){
        visited[src]=true;
        for(int i=0;i<isconnected.length;i++){
            if(isconnected[src][i]==1 && !visited[i]){
                dfs(isconnected,i,visited);
            }
        }
    }
}