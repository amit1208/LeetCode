class Solution {
    private boolean even(int n){
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        return count%2==0?true:false;
    }
    public int findNumbers(int[] nums) {
        int count=0;
        for(int n:nums){
            if(even(n)){
                count++;
            }
        }
        return count;
    }
}