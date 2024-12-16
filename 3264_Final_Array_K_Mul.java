// import java.util.PriorityQueue;

// class Solution {
//     public int[] getFinalState(int[] nums, int k, int multiplier) {
//         int n = nums.length;
//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//         (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b)
//         );
//         for (int i = 0; i < n; i++) {
//             pq.add(i);
//         }
//         for (int i = 0; i < k; i++) {
//             int minIndex = pq.poll();
//             nums[minIndex] *= multiplier;
//             pq.add(minIndex);
//         }
//         return nums;
//     }
// }
class Solution {
    public int[] getFinalState(int[] arr, int k, int multiplier) {
        while (k > 0) {
            int x = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[x]) {
                    x = i;
                }
            }
            arr[x] = arr[x] * multiplier;
            k--;
        }
        return arr;
    }
}

