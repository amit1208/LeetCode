class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset=new HashSet<>();

        for(int a:nums){
        if(hset.contains(a)){
            return true;
        }
        hset.add(a);
        }
        return false;
    }
}