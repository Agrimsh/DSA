class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int a = times[i][0];
            int b = times[i][1];
            int c = times[i][2];

            adj.get(a).add(new int[] { b, c });
            
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        q.add(new int[] { k, 0 });

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dis[node])
                continue;

            for (int neigh[] : adj.get(node)) {
                int newnode = neigh[0];
                int newd = neigh[1];

                if (dis[node] + newd < dis[newnode]) {
                    dis[newnode] = dis[node] + newd;
                    q.add(new int[] { newnode, dis[newnode] });
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dis[i]);
        }
        return max;

    }
}