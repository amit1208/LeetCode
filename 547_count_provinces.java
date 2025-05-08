class Solution {

    public void dfs(int[][] isConnected,boolean[] vis,int city){
        vis[city]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[city][j]==1 && !vis[j]){
                    dfs(isConnected, vis, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean[] vis=new boolean[v];

        int res=0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]!=true){
                dfs(isConnected,vis,i);
                res++;
            }
        }
        
        return res;
    }
}