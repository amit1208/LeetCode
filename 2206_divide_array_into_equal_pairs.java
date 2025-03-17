class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] check = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) { 
                boolean paired = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j] && !check[j]) {
                        check[i] = true;
                        check[j] = true;
                        paired = true;
                        break;
                    }
                }
                if (!paired) return false;  
            }
        }

        return true;
    }
}
