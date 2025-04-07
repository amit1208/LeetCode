// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int count=0,sum=0;
//         int right=0,left=0;
//             sum=sum+nums[right];
//         while(right<nums.length && left<nums.length){
//             if(sum==goal){count++; right++;}
//             else if(sum<goal){sum=sum+nums[right];right++;}
//             else if(sum>goal){sum=sum-nums[left++];}
//         }
//         return count;
//     }
// }
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        int count = 0, sum = 0;
        
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
