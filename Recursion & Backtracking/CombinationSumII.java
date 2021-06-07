class Solution {
    List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates,target,0,ans);
        return ans2;   
    }
     public void combinationSumHelper(int[] candidates,int target,int idx,List<Integer> ans){
        if(target == 0){
            if(!ans2.contains(ans))
                ans2.add(new ArrayList<>(ans));
            return;
        }
         if(idx == candidates.length || target<0){
            return;
        }
                    ans.add(candidates[idx]);
                    combinationSumHelper(candidates,target - candidates[idx],idx+1,ans);
                    ans.remove(ans.size() - 1);
                    combinationSumHelper(candidates,target,idx+1,ans);


    }
}