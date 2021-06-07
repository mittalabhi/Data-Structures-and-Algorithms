class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int d[] : dp) Arrays.fill(d,-1);
        return maxCoins(nums,0,n-1,dp);
    }
    public int maxCoins(int nums[],int si,int ei,int dp[][]){
        if(dp[si][ei] != -1){
            return dp[si][ei];
        }

        int lVal = si == 0 ? 1 : nums[si - 1];
        int rVal = ei == nums.length - 1 ? 1 : nums[ei + 1]; 
        int maxVal = 0;
        for(int cut = si; cut <= ei; cut++){
            int left =  si == cut ? 0 : maxCoins(nums,si,cut - 1,dp);
            int right = ei == cut ? 0 : maxCoins(nums,cut + 1,ei,dp);

            maxVal = Math.max(maxVal,left + lVal * nums[cut] * rVal + right);
        }
        dp[si][ei] = maxVal;
        return maxVal;
    }
}
