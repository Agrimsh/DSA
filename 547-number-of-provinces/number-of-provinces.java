class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean visited[]=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                count++;
            }
        } 
        return count;
    }
    void dfs(int src,int arr[][],boolean visited[]){
        visited[src]=true;
        for(int i=0;i<arr.length;i++){
            if(arr[src][i]==1 && !visited[i]){
                dfs(i,arr,visited);
            }
        }
    }
}