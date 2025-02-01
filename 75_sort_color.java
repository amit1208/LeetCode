class Solution {
    public void sortColors(int[] nums) {
    for(int j=0;j<nums.length-1;j++){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] ){
                nums[i]=nums[i]+nums[i+1];
                nums[i+1]=nums[i]-nums[i+1];
                nums[i]=nums[i]-nums[i+1];
            }
        }
    }
    }
}

// 2 pointers
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;        // pointer for 0s
        int right = nums.length - 1;  // pointer for 2s
        int current = 0;     // current position
        
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}