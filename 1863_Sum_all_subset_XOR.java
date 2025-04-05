public class Solution {

    public static int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private static int backtrack(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }

        int include = backtrack(nums, index + 1, currentXor ^ nums[index]);
        int exclude = backtrack(nums, index + 1, currentXor);

        return include + exclude;
    }
    }