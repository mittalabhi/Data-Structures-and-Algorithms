class Solution {
    public int lengthOfLIS(int[] nums) {
//         int max=0;
//         int dp[] = new int[nums.length];
//         for(int i=0;i<nums.length;i++)
//         {
//            max=Math.max(max,lengthOfLISHelperD(nums,i,dp));
//         }
//         for(int i=0;i<dp.length;i++)
//         {
//             System.out.print(dp[i]+" ");
//         }
//         return max;
        
//     }
//     int lengthOfLISHelper(int[] nums,int idx,int[] dp)
//     {
//         if(idx==0)
//         {
//             dp[idx]=1;
//             return 1;
//         }
//         if(dp[idx]!=0)
//             return dp[idx];
//         int max=1;
//         for(int i=idx-1;i>=0;i--)
//         {
//             if(nums[idx]>nums[i])
//             {
//                 max= Math.max(max,lengthOfLISHelper(nums,i,dp)+1);
//             }
//         }
//         return dp[idx]=max;
//     }
//     //longest decreasing subsequence
//     int lengthOfLISHelperD(int[] nums,int idx,int[] dp)
//     {
//         if(idx==0)
//         {
//             dp[idx]=1;
//             return 1;
//         }
//         if(dp[idx]!=0)
//             return dp[idx];
//         int max=1;
//         for(int i=idx-1;i>=0;i--)
//         {
//             if(nums[idx]<nums[i])
//             {
//                 max= Math.max(max,lengthOfLISHelperD(nums,i,dp)+1);
//             }
//         }
//         return dp[idx]=max;

        ////////////////////////////////TABULATION//////////////////////////////
    int dp[]= new int[nums.length];
        int res=0;
        dp[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            dp[i]=1;
            
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j] && dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                }
            }
            
        }
        for(int i=0;i<dp.length;i++ )
        {
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    
}