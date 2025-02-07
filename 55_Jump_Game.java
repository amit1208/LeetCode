class Solution {
    public boolean canJump(int[] nums) {

    }
}







// Not Efficient 

class Solution {
    public boolean canJump(int[] nums) {
        int last=nums.length-1;
        int sum=nums[0];
        if(sum==0 || sum==1 && nums.length==1) return true;

        while(sum<=last){
            if(sum==last || nums[sum]==last){
                return true;
            }
            if(nums[sum]==0) break;
            else{
                sum=sum+nums[sum];
            }
        }
return false;
    }
}