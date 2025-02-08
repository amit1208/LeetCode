class Solution {

    public boolean canJump(int[] nums) {
        int l=nums.length-1;
    for(int i=l-1;i>=0;i--){

       if (i + nums[i] >= l) {
                l = i;
            }
        }
        return l == 0;
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