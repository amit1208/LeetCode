class Solution {
    public int sum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        
        int max=-1;
        HashMap<Integer,Integer> hmap=new HashMap<>();

        for (int a:nums){
            if(hmap.containsKey(sum(a))){
                 max=Math.max(max,a+hmap.get(sum(a)));
                hmap.put(sum(a), Math.max(hmap.get(sum(a)), a));
            }
            else{
            hmap.put(sum(a),a);
            }
        }
            
        return max;
    }
}



class Solution {
    public int sum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        
        int max=-1;

        for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums.length;j++){
               if(i!=j && sum(nums[i])==sum(nums[j])){
                max=Math.max(max,nums[i]+nums[j]);
               }
            }
        }
        return max;
    }
}