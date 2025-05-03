class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;

        int[] arr=new int[10001];
          Arrays.fill(arr, -1);
        int[] res=new int[l1];
        Stack<Integer> st=new Stack<>();

      for (int i = l2 - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            if (!st.isEmpty()) {
                arr[nums2[i]] = st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<l1;i++){
            res[i]=arr[nums1[i]];
        }

        return res;
    }
}