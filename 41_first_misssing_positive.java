class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number at its correct index (nums[i] == i + 1)
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 && nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Find the first index where the number is incorrect
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}


// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Arrays.sort(nums);
//         int k = 1;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > 0) {
//                 if (nums[i] == k) {
//                     k++;
//                 } else if (nums[i] > k) {
//                     return k;
//                 }
//             }
//         }
//         return k;
//     }
// }

// class Solution {
//     public int firstMissingPositive(int[] nums) {
         
//         int n=nums.length;
//         int maxx=Integer.MIN_VALUE;
//         int m=Integer.MIN_VALUE;
//         for(int a:nums){
//             maxx=Math.max(a,maxx);
//         }
//         boolean[] arr=new boolean[maxx+1];
//         for(int a:nums){
//             if(a>0){
//             arr[a]=true;
//             }
//         }

//         for(int i=1;i<=maxx;i++){
//             if(arr[i]==false)
//            return i;
//         }
//         return maxx+1;
//     }
// }