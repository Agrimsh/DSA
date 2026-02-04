class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         boolean visited[]=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
            bfs(source,adj,n,visited);
        if(visited[destination]==true){
            return true;
        }
        else{
            return false;
        }
        
    }
     static void bfs(int source,List<List<Integer>> adj,int n,boolean visited[]){

       
        Queue <Integer>q=new LinkedList<>();
        visited[source]=true;
        q.add(source);

        while(!q.isEmpty()){
            int curr=q.poll();

            for(int x:adj.get(curr)){
                if(!visited[x]){
                     visited[x] = true;
                        q.add(x);
                }
            }

        }   

    }
}