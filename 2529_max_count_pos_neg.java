class Solution {
    public int maximumCount(int[] nums) {
        int countneg=0; 
        int countpos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) countneg++;
            if(nums[i]>0) countpos++;
        }
        return Math.max(countpos,countneg);
    }
}