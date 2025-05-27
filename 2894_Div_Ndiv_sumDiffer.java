class Solution {
    public int differenceOfSums(int n, int m) {
        int div=0;
        int sum=0;
        for(int i=0;i<=n;i++){
            if(i%m==0){
                div+=i;
            }
            sum+=i;
        }
        return sum-2*div;
    }
}