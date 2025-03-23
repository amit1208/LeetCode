class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        if(n==1 || n==2) return 1;

    List<int[]> graph[] =new ArrayList[n];
    for(int i=0;i<n;i++){
        graph[i] =new ArrayList<>();
    }

    for(int[] r:roads){
        int u=r[0] ;int v=r[1]; int w= r[2];
        graph[u].add(new int[]{v,w});
        graph[v].add(new int[]{u,w});
    }

     PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long currDist = curr[1];
            
            if (currDist > dist[node]) continue;
            
            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                long newDist = currDist + neighbor[1];
                
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{nextNode, newDist});
                } else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    
        
    }
}