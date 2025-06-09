class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // We start from 1, so skip the first number

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);

            if (steps <= k) {
                curr++;      // Skip to the next sibling
                k -= steps;  // Skip the whole subtree
            } else {
                curr *= 10;  // Go deeper into this prefix
                k--;         // Move one step down
            }
        }

        return curr;
    }

    // Count steps between prefix1 and prefix2 (how many numbers are there with this prefix)
    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1L, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}
