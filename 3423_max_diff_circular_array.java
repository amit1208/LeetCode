class Solution {
    public int maxAdjacentDistance(int[] nums) {
       int max=nums[nums.length-1]-nums[0];
       int diff=0;
        for(int i=0;i<nums.length-1;i++){
            diff=nums[i]-nums[i+1];
            max=Math.max(Math.abs(max),Math.abs(diff));
            }
            return max;
    }
}