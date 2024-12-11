class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        // Expand around each center to find palindromes
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Even-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);

            // Find the maximum length of the palindrome
            int maxLen = Math.max(len1, len2);

            // Update the start and end pointers if a longer palindrome is found
            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center and return the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
// }


// class Solution {
//     public boolean isPalindrom(String sub){
//         boolean flag=true;
//         for(int i=0;i<sub.length()/2;i++){
//         if(sub.charAt(i)!=sub.charAt(sub.length()-i-1)){
//             flag=false;
//             break;
//         }
//         }
//         return flag;
//     }

//     public String longestPalindrome(String s) {
//         HashMap<String,Boolean> map=new HashMap<>();
//         int n = s.length();
//         for (int left = 0; left < n; left++) {
//             for (int right = left + 1; right <= n; right++) {
//                 map.put(s.substring(left, right),isPalindrom(s.substring(left, right)));
//             }

//     }

//    String longest = "";
//         for (Map.Entry<String, Boolean> entry : map.entrySet()) {
//             if (entry.getValue() == true && entry.getKey().length() > longest.length()) {
//                 longest = entry.getKey();
//             }
//         }
// return longest;
// }}