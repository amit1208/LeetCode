
import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2; // Total pairs in an array
        long goodPairs = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            int key = j - nums[j]; // Unique identifier for good pairs
            goodPairs += freq.getOrDefault(key, 0);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs; // Bad pairs = Total pairs - Good pairs
    }
}



// brute Force Approach
class Solution {
    public long countBadPairs(int[] nums) {
        long num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {

                if (j - i != nums[j] - nums[i] && i < j && i != j) {
                    num++;
                }
            }
        }
        return num;
    }
}