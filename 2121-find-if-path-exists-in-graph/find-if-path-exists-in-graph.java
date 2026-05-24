class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean visited[] = new boolean[n + 1];
        bfs(source,adj,visited);
        if (visited[destination] == true) {
            return true;
        } else {
            return false;
        }

    }

    public void bfs(int src, List<List<Integer>> adj, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adj.get(curr)) {
                if (visited[neigh] == false) {
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }
        }

    }
}