class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] answer = new int[query.length];
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        // Use Union-Find to check connectivity
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
        }
        
        // Precompute minimum cost for each connected component
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            minCost[root] &= minCost[i];
            for (int[] neighbor : graph[i]) {
                minCost[root] &= neighbor[1];
            }
        }
        
        // Answer queries
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];
            if (find(parent, s) != find(parent, t)) {
                answer[i] = -1;
            } else {
                answer[i] = minCost[find(parent, s)];
            }
        }
        
        return answer;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) parent[rootY] = rootX;
    }
}
