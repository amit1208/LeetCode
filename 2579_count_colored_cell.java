class Solution {

    public long usingdp(int n,long dp[]){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];

        return dp[n]=usingdp(n - 1, dp) + (n - 1) * 4;
    }

    public long coloredCells(int n) {
     
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);

        return usingdp(n,dp);
    }

}

class Solution {
    public long coloredCells(int n) {
        return (long) n * n + (long) (n - 1) * (n - 1);
    }
}
