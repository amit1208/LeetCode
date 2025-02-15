class Solution {
    public void combinationsfun(int idx, int[] candidates, int target,List<List<Integer>> ans, List<Integer> ds){

        if(idx==candidates.length)
        {
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }


        if(candidates[idx]<=target){
            ds.add(candidates[idx]);
            combinationsfun(idx,candidates,target-candidates[idx],ans,ds);
        } 
        combinationsfun(idx+1,candidates,target,ans,ds);  
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        int idx=0;
        combinationsfun(0,candidates,target,ans,new ArrayList<>());
        return ans; 
    }
}