class Solution {
    List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] candidates={1,2,3,4,5,6,7,8,9};
        combinationSumHelper(candidates,n,0,k,ans);
        return ans2;  
    }
     public void combinationSumHelper(int[] candidates,int target,int idx,int k,List<Integer> ans){
        if(target == 0 && ans.size()==k){
            if(!ans2.contains(ans))
                ans2.add(new ArrayList<>(ans));
            return;
        }
         if(idx == candidates.length || target<0){
            return;
        }
                    ans.add(candidates[idx]);
                    combinationSumHelper(candidates,target - candidates[idx],idx+1,k,ans);
                    ans.remove(ans.size() - 1);
                    combinationSumHelper(candidates,target,idx+1,k,ans);


    }
}