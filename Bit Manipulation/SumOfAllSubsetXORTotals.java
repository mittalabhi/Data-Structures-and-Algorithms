class Solution {
    int sum = 0;
    public void helper(int[] nums,int idx,int res){
        if(idx == nums.length){
            sum += res;
            res = 0;
            return;
    }
        helper(nums,idx + 1,res ^ nums[idx]);
        helper(nums,idx + 1,res);
    }
    public int subsetXORSum(int[] nums) {
        helper(nums,0,0);
        return sum;
    }
}