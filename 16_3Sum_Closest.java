// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Example 2:

// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

// Constraints:

// 3 <= nums.length <= 500
// -1000 <= nums[i] <= 1000
// -104 <= target <= 104




class Solution {

    public int threeSumClosest(int[] nums, int target) {
       
        int temp = Integer.MAX_VALUE;
        int sum=0;
     
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<nums.length-2;i++){
        for(int j=i+1;j<nums.length-1;j++){
        for(int k=j+1;k<nums.length;k++){
    
        if(temp> Math.abs(target - (nums[i] + nums[j] + nums[k]))){
        temp=(Math.abs(target - (nums[i] + nums[j] + nums[k])));
        sum=nums[i] + nums[j] + nums[k];}
        }
        }
        }

        return sum;
    }
}