class Solution {
 public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = (int) 1e9;
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if it's possible to rob at least k houses with max value ≤ mid
            if (canRob(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canRob(int[] nums, int k, int maxCapability) {
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] <= maxCapability) {
                count++;
                i++;  // Skip next house (adjacent)
            }
            i++;  // Move to the next house
        }
        
        return count >= k;
    }
}