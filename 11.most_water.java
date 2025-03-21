class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {

            int water = (right - left) * Math.min(height[left], height[right]);

            if (water > max) {
                max = water;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}