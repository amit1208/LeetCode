// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // Add the string to the corresponding anagram group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Collect all anagram groups into a list
        return new ArrayList<>(map.values());
    }
}




// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<String, List<String>> map = new HashMap<>();
        
//         for (String str : strs) {
//             // Frequency count array for 26 lowercase English letters
//             int[] count = new int[26];
            
//             for (char c : str.toCharArray()) {
//                 count[c - 'a']++;
//             }
            
//             // Convert frequency array into a string key
//             StringBuilder keyBuilder = new StringBuilder();
//             for (int freq : count) {
//                 keyBuilder.append(freq).append("#");
//             }
//             String key = keyBuilder.toString();
            
//             // Add string to the corresponding group
//             map.putIfAbsent(key, new ArrayList<>());
//             map.get(key).add(str);
//         }
        
//         return new ArrayList<>(map.values());
//     }
// }
