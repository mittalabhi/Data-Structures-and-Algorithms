class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        
       return longestCommonSubsequenceHelperDP(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    
    public int longestCommonSubsequenceHelperDP(String text1,String text2, int m , int n,int dp[][])
    {
        if(m==-1||n==-1)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        if(text1.charAt(m)==text2.charAt(n))
        {
          dp[m][n]= 1+ longestCommonSubsequenceHelperDP(text1,text2,m-1,n-1,dp);
        }
        else
        {
            dp[m][n]=Math.max(longestCommonSubsequenceHelperDP(text1,text2,m,n-1,dp),longestCommonSubsequenceHelperDP(text1,text2,m-1,n,dp));
        }
        return dp[m][n];
    }
}L