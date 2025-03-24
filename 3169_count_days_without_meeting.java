class Solution {
    public int countDays(int days, int[][] meetings) {
        boolean vis[]=new boolean[days+1];
        int count=0;
        for(int[] m:meetings){
            int u=m[0];
            int v=m[1];
            for(int i=u;i<=v;i++){
                vis[i]=true;
            }
        }
        for(boolean v:vis){
            if(!v) count++;
        }
        return count == 0?0:count-1 ;
    }
}


import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by start day
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int freeDays = 0;
        int lastEnd = 0;

        for (int[] meeting : meetings) {
            // Count free days between last meeting and current meeting
            if (meeting[0] > lastEnd + 1) {
                freeDays += meeting[0] - lastEnd - 1;
            }
            // Update the last end to the maximum meeting end
            lastEnd = Math.max(lastEnd, meeting[1]);
        }

        // Count free days after the last meeting
        if (lastEnd < days) {
            freeDays += days - lastEnd;
        }

        return freeDays;
    }
}
