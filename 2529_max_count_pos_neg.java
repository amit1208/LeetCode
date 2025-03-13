class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int posCount = n - left;

        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int negCount = right + 1;
        
        return Math.max(posCount, negCount);
    }
}


class Solution {
    public int maximumCount(int[] nums) {
        int countneg=0; 
        int countpos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) countneg++;
            if(nums[i]>0) countpos++;
        }
        return Math.max(countpos,countneg);
    }
}



