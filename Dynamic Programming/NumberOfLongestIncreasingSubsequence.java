class Solution {
    public static int findNumberOfLIS(int[] nums) {
        int dp[]= new int[nums.length];
        int count[]= new int[nums.length];
        dp[0]=1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int res=1;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[i]==dp[j]+1)
                    {
                        count[i]+=count[j];
                    }
                }
            }
                     
        }
        int ans=0;
        for(int i=0;i<dp.length;i++)
        {
            res=Math.max(res,dp[i]);
        }
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]==res)
            {
                ans+=count[i];
            }
        }
        return ans;
    }
}
