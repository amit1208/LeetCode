class Solution {

    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        int odd = 0;
        int even = 1;
        int prefix = 0;
        int count = 0;

        for (int a : arr) {
            prefix = prefix + a;
            if (prefix % 2 == 0) {
                count = (count + odd) % MOD;

                even++;
            } else {
                count = (count + even) % MOD;

                odd++;
            }

        }

        return count;
    }
}
