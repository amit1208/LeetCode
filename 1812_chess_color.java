class Solution {
    public boolean squareIsWhite(String coordinates) {
        if((coordinates.charAt(0)-'a'+1)%2!=0){
            if((int)coordinates.charAt(1) %2 == 0) return true;
            else return false;
        }
        else{
            if((int)coordinates.charAt(1) %2 == 0) return false;
            else return true;
        }
    }
}