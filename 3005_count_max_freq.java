class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
         for(int a:nums){
            hmap.put(a,hmap.getOrDefault(a,0)+1);
            max= Math.max(hmap.get(a),max);
         }
         int sum=0;
         for(int b:hmap.values()){
            if(b==max)
            sum+=b;
         }
    return sum;
    }
}