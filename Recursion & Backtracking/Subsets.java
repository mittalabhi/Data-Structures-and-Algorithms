class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> smallAns = new ArrayList<>();
        helper(nums,0,smallAns);
        return res;
    }
    public void helper(int nums[],int idx,ArrayList<Integer> smallAns){
        if(idx == nums.length){
            res.add(new ArrayList<>(smallAns));
            return;
        }
        smallAns.add(nums[idx]);
        helper(nums,idx + 1,smallAns);
        smallAns.remove(smallAns.size() - 1);
        helper(nums,idx + 1,smallAns);
    }
}