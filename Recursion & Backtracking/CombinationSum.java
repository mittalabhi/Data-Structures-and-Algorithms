class Solution {
        List<List<Integer>> ans2 = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        combinationSumHelper(candidates,target,0,ans);
        return ans2;
    }
    public void combinationSumHelper(int[] candidates,int target,int idx,List<Integer> ans){
        if(target < 0){
            return;
        }
        if(idx > candidates.length - 1){
            return;
        }
        if(target == 0){
            ans2.add(new ArrayList<>(ans));
            return;
        }
        combinationSumHelper(candidates,target,idx+1,ans);
        ans.add(candidates[idx]);
        combinationSumHelper(candidates,target - candidates[idx],idx,ans);
        ans.remove(ans.size() - 1);
    }
}