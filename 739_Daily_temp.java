class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        int left = 0;
        int right = left + 1;

        while (left < n - 1) { 
            if (right < n && temperatures[left] < temperatures[right]) {
                result[left] = right - left;
                left++;
                right = left + 1; 
            } else if (right >= n) { 
                result[left] = 0;
                left++;
                right = left + 1;
            } else {
                right++;
            }
        }

        return result;
    }
}

