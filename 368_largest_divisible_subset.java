import java.util.*;

public class Solution{

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> memo = new HashMap<>();

        return dfs(nums, -1, 0, memo);
    }

    private static List<Integer> dfs(int[] nums, int prevIdx, int currIdx, Map<String, List<Integer>> memo) {
        if (currIdx == nums.length) return new ArrayList<>();

        String key = prevIdx + "," + currIdx;
        if (memo.containsKey(key)) return memo.get(key);

        // Option 1: skip current number
        List<Integer> skip = dfs(nums, prevIdx, currIdx + 1, memo);

        // Option 2: pick current number if divisible
        List<Integer> take = new ArrayList<>();
        if (prevIdx == -1 || nums[currIdx] % nums[prevIdx] == 0) {
            take.add(nums[currIdx]);
            take.addAll(dfs(nums, currIdx, currIdx + 1, memo));
        }

        // Store and return the longer list
        List<Integer> result = (take.size() > skip.size()) ? take : skip;
        memo.put(key, result);
        return result;
    }
}
