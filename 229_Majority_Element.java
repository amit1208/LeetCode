class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        ArrayList<Integer> al=new ArrayList<>();

        for(int n:nums){
        hmap.put(n,hmap.getOrDefault(n,0)+1);
        }
      int threshold = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() > threshold) {
                al.add(entry.getKey());
            }
        }

        return al;
    }
}
