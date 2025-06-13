class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
        min=Math.min(Math.abs(arr[i]-arr[i+1]),min);
        }
        for(int i=0;i<arr.length-1;i++){
        if(Math.abs(arr[i]-arr[i+1])==min){
        list.add(Arrays.asList(arr[i], arr[i + 1]));
        }       
        }
        return list;
    }
}