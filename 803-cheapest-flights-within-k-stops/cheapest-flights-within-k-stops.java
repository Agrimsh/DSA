class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int a=flights[i][0];
            int b=flights[i][1];
            int cost=flights[i][2];

            adj.get(a).add(new int[]{b,cost});
        }
        Queue<int[]>q=new LinkedList<>();
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        q.add(new int[]{src,0,0});
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int node=curr[0];
            int cost=curr[1];
            int stops=curr[2];

            if(stops>k){
                continue;
            }
            for(int neigh[]:adj.get(node)){
                int newnode=neigh[0];
                int newcost=neigh[1];
                if(cost+newcost<dis[newnode]){
                    dis[newnode]=cost+newcost;
                 q.add(new int[]{newnode,dis[newnode],stops+1});
                }
            }
        }
       if(dis[dst]==Integer.MAX_VALUE){
        return-1;
       }
       else{
        return dis[dst];
       }
        
    }
}