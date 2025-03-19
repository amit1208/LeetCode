class Solution {
    public int minOperations(int[] nums) {
        int ops=0;
        int n=nums.length;
        int left=0,right=0;

        while(left<=n-3){
            if(nums[left]==0){
                for(int i=0;i<3;i++){
                    nums[left + i] = 1 - nums[left + i];
                }
                    ops++;
            }
            else{
                left++;
            }
        }
        
return (nums[n - 1] != 0 && nums[n - 2] != 0 && nums[n - 3] != 0) ? ops : -1;
    }
}