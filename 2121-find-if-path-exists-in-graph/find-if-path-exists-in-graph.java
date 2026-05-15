class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);

        }
        boolean vis[]=new boolean[adj.size()];
        vis[source]=true;
        bfs(source,adj,vis);
        if(vis[destination]==true)return true;
        else return false;
        
    }
    public void bfs(int src,List<List<Integer>>adj, boolean vis[]){
        Queue<Integer>q=new LinkedList<>();
        vis[src]=true;
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int x:adj.get(curr)){
                if(!vis[x]){
                    q.add(x);
                    vis[x]=true;
                }
            }
        }
    }
}