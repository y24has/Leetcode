class Solution {
    public int minReorder(int n, int[][] connections) {
         // adjacency list: child -> [node, flag]
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list exactly how YOU described:
        // u -> v gets flag 0  (original input direction)
        // v -> u gets flag 1  (artificial reverse direction)
        for (int[] c : connections) {
            int u = c[0];
            int v = c[1];

            adj.get(u).add(new int[]{v, 1});  // input direction
            adj.get(v).add(new int[]{u, 0});  // reverse direction
        }

        boolean[] visited = new boolean[n];
        int[] count = new int[1]; // because you wanted to pass an array for count

        dfs(0, adj, visited, count);

        return count[0];
    }

    private void dfs(int node, List<List<int[]>> adj, boolean[] visited, int[] count) {
        visited[node] = true;

        for (int[] edge : adj.get(node)) {
            int next = edge[0];
            int flag = edge[1];

            if (!visited[next]) {

                // YOUR condition:
                // If flag == 1 (As it is Age going Outwards towards the Child Note, which is supposed to come Inwards.), increment count
                if (flag == 1) {
                    count[0]++;
                }

                dfs(next, adj, visited, count);
            }
        }
    }
}