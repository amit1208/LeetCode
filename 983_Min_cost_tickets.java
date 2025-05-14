class Solution {
    public int dpf(int[] days, int[] costs,int[] dp,int n,int i){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];

        int a=costs[0] + dpf(days,costs,dp,n,i+1);

        int j=i;
        int max_day=days[i]+7;
        while(j<n && days[j]<max_day){
            j++;
        }
        int b=costs[1] + dpf(days,costs,dp,n,j);

        int k=i;
        int max_day3=days[i]+30;
        while(k<n && days[k]<max_day3){
            k++;
        }
        int c=costs[2] + dpf(days,costs,dp,n,k);

       return dp[i]=Math.min(a,Math.min(b,c));

    }


    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;

        int dp[]=new int[366];
        Arrays.fill(dp,-1);

        return dpf(days,costs,dp,n,0);

    }
}