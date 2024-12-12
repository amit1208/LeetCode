class Solution {
    public long minimumSteps(String s) {
        long count = 0;
        long swaps = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                swaps++;
            } else if (ch == '0' && swaps > 0) {
                count += swaps;
            }
        }
        return count;
    }
}


// class Solution {
//     public long minimumSteps(String s) {
//         char[] charArray = s.toCharArray();
//         long count =0;

//         for(int j=0;j<s.length();j++){
//         for (int i = 0;i<s.length()-1;i++) {
//             if (charArray[i]=='1' && charArray[i+1]=='0')
//            { charArray[i]='0';
//             charArray[i+1]='1'; 
//             count++;}
//         }
//         }
//         return count;
//     }
// }
