
class Solution {
    //tabulation
    public int climbStairsTabulation(int n)
    {
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //memoization
    public int climbStairsDp(int n,int[] dp)
    {
        if(n==0||n==1||n==2)
        {
            dp[n]=n;
            return n;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        int n1=climbStairsDp(n-1,dp);
        int n2=climbStairsDp(n-2,dp);
        dp[n]=n1+n2;
        return dp[n];
    }
    public int climbStairs(int n) {
    
        int dp[]= new int[n+1];
        int ans= climbStairsTabulation(n);
        return ans;
    }
}