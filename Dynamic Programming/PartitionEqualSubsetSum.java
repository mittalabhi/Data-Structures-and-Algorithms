class Solution {
    public int CheckTarget(int []nums,int target,int idx,int [][]dp)
    {
        if(target == 0 || idx == nums.length)
        {
            return target == 0 ? 1 : 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        boolean res = false;
        if(target - nums[idx] >= 0){
            res = res || CheckTarget(nums,target - nums[idx],idx + 1,dp) == 1;
        }
        res = res || CheckTarget(nums,target,idx + 1,dp) == 1;
        return dp[idx][target] = res == true ? 1 : 0;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele:nums) sum += ele;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        
        int dp[][] = new int[nums.length + 1][target + 1];
        for(int d[]:dp) Arrays.fill(d,-1);
        
        int ans = CheckTarget(nums,target,0,dp);
        return ans == 1 ? true : false;
    }
}