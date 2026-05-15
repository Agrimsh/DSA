class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] =new boolean[rooms.size()];
        bfs(0,rooms,vis);
        for(boolean ele:vis){
            if(ele==false)return false;
        }
        return true;  
    }
    public void bfs(int src,List<List<Integer>>rooms,boolean vis[]){
        Queue<Integer>q=new LinkedList<>();
        vis[src]=true;
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:rooms.get(curr)){
                if(!vis[neigh]){
                    q.add(neigh);
                    vis[neigh]=true;
                }
            }
        }
    }
}