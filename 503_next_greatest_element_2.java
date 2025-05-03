class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            int index = i % n;
            while(!st.isEmpty() && nums[index]>=st.peek())
            {st.pop();}
                   if (!st.isEmpty()) {
                arr[index] = st.peek();
            } else {
                arr[index] = -1;
            }
            st.push(nums[index]);
        }
        return arr;
    }
}