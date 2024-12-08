class Solution {
    public int subarraySum(int[] nums, int k) {

        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int p=i;p<nums.length;p++) {
                    sum += nums[p];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
