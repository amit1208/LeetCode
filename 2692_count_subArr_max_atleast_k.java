class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxV = 0;
        for (int a : nums) maxV = Math.max(maxV, a);

        long count = 0;
        int left = 0;
        int freq = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxV) {
                freq++;
            }

            while (freq >= k) {
                count += nums.length - right;
                if (nums[left] == maxV) freq--;
                left++;
            }
        }

        return count;
    }
}
