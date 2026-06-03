class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[]=new boolean[isConnected.length+1];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
           if(!visited[i]){
            bfs(isConnected,i,visited);
            count++;
           }
        } 
        return count;
    }
    public void bfs(int[][]isConnected,int src,boolean visited[]){
         Queue<Integer> q=new LinkedList<>();
        visited[src]=true;
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[curr][i]==1&&visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}