class Solution {
    static final int MOD=1000000007;
    public int reverseN(int x){
        int temp=0;
        while(x>0){
            temp=temp*10+x%10;
            x/=10;
        }
        return temp;
    }
    public int countNicePairs(int[] nums) {
        long count=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {
        int key = num - reverseN(num);
        count = (count + map.getOrDefault(key, 0)) % MOD;
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    return (int) count;
}
}