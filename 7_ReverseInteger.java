class Solution {
    public int reverse(int x) {
        int newx = Math.abs(x);

        int rev = 0;
        while (newx > 0) {
            int digit = newx % 10;
             if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            rev = rev * 10 + digit;
            newx /= 10;
        }
    
        return (x<0)? -rev:rev;
        }
}
