class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Track visited nodes
        boolean[] visited = new boolean[n];
        int completeCount = 0;

        // Step 3: Traverse all nodes to identify components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);

                // Step 4: Check if the component is complete
                if (isComplete(graph, component)) {
                    completeCount++;
                }
            }
        }
        return completeCount;
    }

    // DFS to find all nodes in a component
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    // Check if the component is complete
    private boolean isComplete(List<List<Integer>> graph, List<Integer> component) {
        int size = component.size();
        for (int node : component) {
            if (graph.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
