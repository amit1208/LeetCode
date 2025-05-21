class Solution {
public boolean isZeroArray(int[] nums, int[][] queries) {
    int n = nums.length;
    int[] count = new int[n + 1];

    // Difference array approach to count how many queries affect each index
    for (int[] q : queries) {
        int l = q[0], r = q[1];
        count[l]++;
        if (r + 1 < n) count[r + 1]--;
    }

    // Convert to prefix sum to get actual coverage count
    for (int i = 1; i < n; i++) {
        count[i] += count[i - 1];
    }

    // Now check: is nums[i] <= count[i]?
    for (int i = 0; i < n; i++) {
        if (nums[i] > count[i]) return false;
    }

    return true;
}
}

// Brute Force
// class Solution {
//     public boolean isZeroArray(int[] nums, int[][] queries) {
//         for(int[] q:queries){
//             int left=q[0];
//             int right=q[1];
//             for(int i=left;i<=right;i++){
//                 if(nums[i]!=0){
//                     nums[i]--;
//                 }
//             }
//         }
// for (int n : nums) {
//     if (n != 0) return false;
// }
// return true;
//     }
// }


