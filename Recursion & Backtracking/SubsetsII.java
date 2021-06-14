class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int nums[],int idx,List<Integer> ans,boolean vis){
        if(idx == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

         helper(nums,idx + 1,ans,false);
        if(idx > 0 && nums[idx] == nums[idx -1] && (!vis)){
            return;
        }
        ans.add(nums[idx]);
        helper(nums,idx + 1,ans,true);

        ans.remove(ans.size() - 1);


    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        helper(nums,0,ans,false);
        return res;
    }
}
