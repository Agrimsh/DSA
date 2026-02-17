class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int temp[]:times){
            int u=temp[0];
            int v=temp[1];
            int w=temp[2];
            adj.get(u).add(new int[]{v, w});

        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int dis[]=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[k]=0;
        q.add(new int[]{k,0});

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int node=curr[0];
            int d=curr[1];

            if (d > dis[node]) continue; 

            for(int x[]: adj.get(node)){
                int newnode=x[0];
                int newd=x[1];

                if(dis[node]+newd<dis[newnode]){ 
                   dis[newnode]=dis[node]+newd;
                   q.add(new int[]{newnode,dis[newnode]}); 
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            max= Math.max(max,dis[i]);
        }
        return max;
        
    }
}