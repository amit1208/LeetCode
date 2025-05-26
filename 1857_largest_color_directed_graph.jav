class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<List<Integer>> graph=new ArrayList<>();
        int[] inDegree=new int[n];

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> queue =new LinkedList<>();
        for(int i=0;i<n;i++){
        if(inDegree[i]==0) queue.add(i);
        }

        int[][] colorCount=new int[n][26];
        int visited=0;
        int maxColorValue=0;

        while(!queue.isEmpty()){
            int node=queue.poll();
            visited++;
            int colorIndex=colors.charAt(node)-'a';
            colorCount[node][colorIndex]++;
            maxColorValue=Math.max(colorCount[node][colorIndex],maxColorValue);

            for(int neighbor:graph.get(node)){
                for(int i=0;i<26;i++){
                    colorCount[neighbor][i]=Math.max(colorCount[neighbor][i],colorCount[node][i]);
                }
                inDegree[neighbor]--;
                                if (inDegree[neighbor] == 0) queue.offer(neighbor);

            }
        }
        return visited==n ? maxColorValue:-1;

    }
}