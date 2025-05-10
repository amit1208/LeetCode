class Solution {
    public long minSum(int[] nums1, int[] nums2) {
     int z1=0,z2=0;   
     long s1=0,s2=0;
     for(int a:nums1){if(a==0) z1++; else s1+=a;}   
     for(int a:nums2){if(a==0) z2++; else s2+=a;}  

     long minPossible = Math.max(s1 + z1, s2 + z2);

      if(s1+z1<s2+z2 && z1==0) return -1;
      if(s2+z2<s1+z1 && z2==0) return -1;
        return minPossible;
    }} 