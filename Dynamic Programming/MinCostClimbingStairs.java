class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp1[]= new int[cost.length];
        int dp2[]= new int[cost.length];
       int ans1= minCostClimbingStairsHelperDP(cost,0,dp1);
        int ans2= minCostClimbingStairsHelperDP(cost,1,dp2);
        return Math.min(ans1,ans2);
    }
    static int minCostClimbingStairsHelper(int[] cost,int s)
    {
       if(s>cost.length-1)
       {
           return 0;
       }
        
       int f= minCostClimbingStairsHelper(cost,s+1);
       int l=minCostClimbingStairsHelper(cost,s+2);
       int ans=Math.min(f,l)+cost[s];
       return ans;
        
    }
    static int minCostClimbingStairsHelperDP(int[] cost,int s,int dp[])
    {
       if(s>cost.length-1)
       {
           return 0;
       }
        if(dp[s]!=0)
        {
            return dp[s];
        }
       int f= minCostClimbingStairsHelperDP(cost,s+1,dp);
       int l=minCostClimbingStairsHelperDP(cost,s+2,dp);
       int ans=Math.min(f,l)+cost[s];
        dp[s]=ans;
       return ans;
        
    }
}