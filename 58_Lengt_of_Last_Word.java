class Solution {
    public int lengthOfLastWord(String s) {
    String[] parts = s.split("\\s+");  
    int l=parts.length;  
    return parts[l-1].length();
     }   
    }



        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');        
        return s.length() - lastSpaceIndex - 1;
