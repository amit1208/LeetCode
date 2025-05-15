class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> al=new ArrayList<>();
        for(int i=0;i<groups.length;i++){
            if(i==0 || groups[i]!=groups[i-1] ){
                al.add(words[i]);
            }
        }

        return al;
    }
}
// class Solution {
//     public List<String> getLongestSubsequence(String[] words, int[] groups) {
//         List<String> al=new ArrayList<>();
//         List<String> al1=new ArrayList<>();

//         int pre=0;
//         int pre1=1;
//         for(int i=0;i<groups.length;i++){
//             if(groups[i]!=pre){
//                 al.add(words[i]);
//                 pre=groups[i];
//             }
//             if(groups[i]!=pre1){
//                 al1.add(words[i]);
//                 pre1=groups[i];
//             }
//         }

//         return al.size()>al1.size() ? al:al1;
//     }
// }