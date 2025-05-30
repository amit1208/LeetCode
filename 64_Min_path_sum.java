class Solution {

    public int path(int[][] grid,int i,int j,int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        return 
        dp[i][j]=Math.min(path(grid,i-1,j,dp),path(grid,i,j-1,dp)) + grid[i][j];
        
    }


    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int[] row:dp)
        Arrays.fill(row,-1);
        int minsum=0;

        return path(grid,m-1,n-1,dp);

    }
}