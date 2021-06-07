class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m][n];
        return uniquePathsHelperDP(0,0,m-1,n-1,dp);
    }
    //using recursion
    public int uniquePathsHelper(int sr,int sc,int er,int ec)
    {
        if(sr==er && sc==ec)
        {
            return 1;
        }
        if(sr>er || sc>ec)
        {
            return 0;
        }
        
        int f= uniquePathsHelper(sr+1,sc,er,ec);
        int s= uniquePathsHelper(sr,sc+1,er,ec);
        int ans=f+s;
        return ans;
        
    }
    
     public int uniquePathsHelperDP(int sr,int sc,int er,int ec,int dp[][])
    {
        if(sr==er && sc==ec)
        {
            dp[sr][sc]=1;
            return 1;
        }
        if(sr>er || sc>ec)
        {
            return 0;
        }
         if(dp[sr][sc]!=0)
         {
             return dp[sr][sc];
         }
        
        int f= uniquePathsHelperDP(sr+1,sc,er,ec,dp);
        int s= uniquePathsHelperDP(sr,sc+1,er,ec,dp);
        int ans=f+s;
         dp[sr][sc]=ans;
        return dp[sr][sc];
        
    }
}