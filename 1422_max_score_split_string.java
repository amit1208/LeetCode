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