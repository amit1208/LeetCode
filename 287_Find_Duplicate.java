class Solution {
    public int findDuplicate(int[] nums) {
        int target=-1;
        int freq[]=new int[nums.length+1];

        for(int a:nums){
            if(freq[a]==0) {
            freq[a]=1;}
              else{ target=a;}
             }

        return target;
    }
}