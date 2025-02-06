class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
           nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int i = m - 1; // Pointer for nums1
//         int j = n - 1; // Pointer for nums2
//         int k = m + n - 1; // Pointer for final position in nums1

//         while (i >= 0 && j >= 0) {
//             if (nums1[i] > nums2[j]) {
//                 nums1[k--] = nums1[i--]; // Move larger element
//             } else {
//                 nums1[k--] = nums2[j--]; 
//             }
//         }

//         while (j >= 0) { // If nums2 has remaining elements
//             nums1[k--] = nums2[j--];
//         }
//     }
// }
