class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int c=102;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(!hmap.containsKey(nums[i])){
            hmap.put(nums[i],1);
            }
            else{
                c=i;
                break;
            }
            }
return c == 102 ? 0 : (int) Math.ceil((c + 1) / 3.0);
    }
}