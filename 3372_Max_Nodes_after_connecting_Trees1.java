import java.util.*;

class Solution {
    public void dfs(List<List<Integer>> graph, int node, int depth, int k, boolean[] visited, int[] count, int root) {
        if (depth > k || visited[node]) return;
        visited[node] = true;
        count[root]++;
        for (int neighbor : graph.get(node)) {
            dfs(graph, neighbor, depth + 1, k, visited, count, root);
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) list1.add(new ArrayList<>());
        for (int i = 0; i < m; i++) list2.add(new ArrayList<>());

        for (int[] edge1 : edges1) {
            list1.get(edge1[0]).add(edge1[1]);
            list1.get(edge1[1]).add(edge1[0]);
        }

        for (int[] edge2 : edges2) {
            list2.get(edge2[0]).add(edge2[1]);
            list2.get(edge2[1]).add(edge2[0]);
        }

        int[] dist1 = new int[n];
        int[] dist2 = new int[m];

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(list1, i, 0, k, visited, dist1, i);
        }

        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[m];
            dfs(list2, i, 0, k - 1, visited, dist2, i); // subtract 1 for the connecting edge
        }

        int max = 0;
        for (int a : dist2) {
            max = Math.max(max, a);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = dist1[i] + max;
        }

        return result;
    }
}
