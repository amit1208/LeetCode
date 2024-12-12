class Solution {
    public long pickGifts(int[] g, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : g)
            maxHeap.add(val);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            int x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }
}


// class Solution {
//     public long pickGifts(int[] gifts, int k) {
//         int idx=gifts.length;
//         int sum=0;
//         while(k>0){
//             Arrays.sort(gifts);
//         gifts[idx - 1] = (int) Math.floor(Math.pow(gifts[idx - 1], 0.5)); 
//         k--;
//         }
//         for(int i=0;i<idx;i++){
//             sum=sum+gifts[i];
//         }
//         return sum;
//     }
// }


