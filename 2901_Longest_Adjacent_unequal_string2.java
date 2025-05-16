import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];       // dp[i] = max length ending at i
        int[] parent = new int[n];   // parent[i] = previous index in path

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    isHammingDistanceOne(words[i], words[j])) {
                    
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }

        // Find the index with the maximum dp value
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        // Reconstruct the sequence
        List<String> result = new ArrayList<>();
        for (int i = maxIdx; i != -1; i = parent[i]) {
            result.add(words[i]);
        }
        Collections.reverse(result);
        return result;
    }

    private boolean isHammingDistanceOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
