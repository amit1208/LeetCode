class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n]; 
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        int case1 = robHelper(nums, 0, n - 2, dp1);

        Arrays.fill(dp2, -1);
        int case2 = robHelper(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    public int robHelper(int[] nums, int start, int end, int[] dp) {
        if (start > end) return 0; 
        if (dp[start] != -1) return dp[start];

        int pick = nums[start] + robHelper(nums, start + 2, end, dp);
        int notPick = robHelper(nums, start + 1, end, dp);

        return dp[start] = Math.max(pick, notPick);
    }
}