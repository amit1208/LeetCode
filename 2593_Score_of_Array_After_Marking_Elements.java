
class Solution {
  public long findScore(int[] nums) {
      int n=nums.length;
      long sum=0;
      boolean[] mark=new boolean[n];
      for(int i=0;i<n;i++){
          int min=Integer.MAX_VALUE;
          int idx=-1;
  for (int j = 0; j < n; j++) {
                if (!mark[j] && nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            if (idx == -1) break;
            if (idx - 1 >= 0) mark[idx - 1] = true;
            if (idx + 1 < n) mark[idx + 1] = true;
            mark[idx] = true;
            sum += nums[idx];
        }
        return sum;
    }
}







// class Solution {
//   public long findScore(int[] nums) {
//     long ans = 0;
//     TreeSet<Pair<Integer, Integer>> numAndIndices =
//         new TreeSet<>((a, b)
//                           -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue())
//                                                            : a.getKey().compareTo(b.getKey()));
//     boolean[] seen = new boolean[nums.length];

//     for (int i = 0; i < nums.length; ++i)
//       numAndIndices.add(new Pair<>(nums[i], i));

//     for (Pair<Integer, Integer> pair : numAndIndices) {
//       final int num = pair.getKey();
//       final int i = pair.getValue();
//       if (seen[i])
//         continue;
//       if (i > 0)
//         seen[i - 1] = true;
//       if (i + 1 < nums.length)
//         seen[i + 1] = true;
//       seen[i] = true;
//       ans += num;
//     }

//     return ans;
//   }
// }


