import java.util.*;

class Solution {
    public static int minOperations(int[] nums, int k) {
        // Step 1: If any value is < k, we can never make it k by reducing
        for (int num : nums) {
            if (num < k) return -1;
        }

        // Step 2: Use a set to collect unique values > k
        Set<Integer> uniqueAboveK = new HashSet<>();
        for (int num : nums) {
            if (num > k) uniqueAboveK.add(num);
        }

        // Step 3: The number of reductions = number of unique values > k
        return uniqueAboveK.size();
    }
}
