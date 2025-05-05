class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] right=new int[n];
        int[] left=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
            else
            right[i]=1;
        }
        int sum=0;
        left[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
            else
            left[i]=1;
        sum=sum+Math.max(left[i],right[i]);
        }
        return sum+Math.max(left[0],right[0]);
    }
}


// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         if (n <= 1) return n;

//         int candies = 1;
//         int inc = 1, dec = 0, prev = 1;

//         for (int i = 1; i < n; i++) {
//             if (ratings[i] >= ratings[i - 1]) {
//                 dec = 0;
//                 prev = (ratings[i] == ratings[i - 1]) ? 1 : prev + 1;
//                 candies += prev;
//                 inc = prev;
//             } else {
//                 dec++;
//                 if (dec == inc) dec++; // peak conflict
//                 candies += dec;
//                 prev = 1;
//             }
//         }

//         return candies;
//     }
// }
