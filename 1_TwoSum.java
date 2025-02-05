class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] op=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                op[0]=j;
                op[1]=i;
                return op;
            }
            }
        }
                return null; 
}
}

class Solution{
    public int[] twoSum(int[] nums, int target) {
        int[] op=new int[2];
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hmap.containskey(target-nums[i]))
            {hmap.put(nums[i],i);}
            else{
                op[0]=i;
                op[1]=hmap.get(target-nums[i]);
            }
        }
        return op; 
    }
}
