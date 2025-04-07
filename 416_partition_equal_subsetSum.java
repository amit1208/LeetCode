import java.util.*;

class Solution {
    public Boolean[][] dp;

    public boolean dfs(int nums[], int target, int idx) {
        if (target == 0) return true;
        if (idx >= nums.length || target < 0) return false;

        if (dp[idx][target] != null) return dp[idx][target];

        boolean sel = dfs(nums, target - nums[idx], idx + 1);
        boolean notsel = dfs(nums, target, idx + 1);

        return dp[idx][target] = sel || notsel;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int a : nums) sum += a;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new Boolean[nums.length][target + 1];

        return dfs(nums, target, 0);
    }
}
