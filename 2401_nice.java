class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, right = 0;
        int maxLen = 1;
        int currMask = 0;

        while (right < nums.length) {
            if ((currMask & nums[right]) == 0) {
                currMask |= nums[right];
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                currMask ^= nums[left];
                left++;
            }
        }
        return maxLen;
    }
}















class Solution {
    public boolean isValid(List<Integer> arr, int c) {
        for (int i=0;i<arr.size();i++) {
            if ((arr.get(i) & c) != 0) {
                return false;
            }
        }
        return true;
    }
 
    public int longestNiceSubarray(int[] nums) {
        int left=0,right=0;
        int max=1;
        List<Integer> arr=new ArrayList<>();

        while(left<=right && right<nums.length){
            if(isValid(arr,nums[right])){
                arr.add(nums[right]);
                max=Math.max(max,arr.size());
                right++;
            }
            else{
                arr=new ArrayList<>();
                arr.add(nums[right]);
            left++;
            right++;};
    }
    return max;
}
}