import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }

        return n == 1;
    }
}


class Solution {
    public boolean isHappy(int n) {
        int sum=0;

        if(n==1){
            return true;
        }

        while(n>0){
           sum+=(n%10)*(n%10);
           n=n/10;
        }

        n=sum;

        if(n/10==0 && n%10!=1) return false;

        return isHappy(n);
    }
}