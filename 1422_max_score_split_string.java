class Solution {
    public int maxScore(String s) {
        int m=Integer.MIN_VALUE;
        for(int i=1;i<s.length();i++){

        String left=s.substring(0,i);
        String right=s.substring(i,s.length());
        int rc=0,lc=0;
        for(char l:left.toCharArray()){
            if(l=='0'){
                lc++;
            }
        }

        for(char r:right.toCharArray()){
            if(r=='1'){
                rc++;
            }
        }
        m=Math.max(m,rc+lc);

    }
    return m;
        }
}

class Solution {
    public int maxScore(String s) {
        int totalOnes = 0, leftZeros = 0, maxScore = Integer.MIN_VALUE;
        
        // Count total number of '1's in the string
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        // Iterate through the string and calculate score dynamically
        for (int i = 0; i < s.length() - 1; i++) {  // Stop at s.length()-1 to ensure non-empty right part
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                totalOnes--;  // Reduce right-side '1's count
            }
            
            // Score = left '0's + right '1's
            maxScore = Math.max(maxScore, leftZeros + totalOnes);
        }
        
        return maxScore;
    }
}
