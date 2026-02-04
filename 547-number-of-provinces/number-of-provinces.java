class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean visited[] = new boolean[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]==false) {
                bfs(isConnected, i, visited);
             count++;
            }
        }
        return count;

    }

    void bfs(int[][] isConnected, int src, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int x = 0; x < isConnected.length; x++) {
                if (!visited[x] && isConnected[curr][x] == 1) {
                    visited[x] = true;
                    q.add(x);
                }

            }
        }
    }

}