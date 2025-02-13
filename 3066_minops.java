class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        int minops=0;

        for(int num:nums){pq.add((long)num);}

           while(pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            minops++;

            pq.add(Math.min(x, y) * 2 + Math.max(x, y));

           } 
    return minops;
    }
}












class Solution {
    public int minOperations(int[] nums, int k) {
        int minops =0;

        ArrayList<Long> al = new ArrayList<>();
        for(int c:nums){al.add((long)c);}
        Collections.sort(al);
 while (al.get(0) < k && al.size() > 1) {
            long x = al.remove(0);  
            long y = al.remove(0); 
            minops++;

            long newVal = Math.min(x, y) * 2 + Math.max(x, y);
            al.add(newVal);

        
            Collections.sort(al);
        }
        return minops;
    }
}