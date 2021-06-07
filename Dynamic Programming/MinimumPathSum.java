class Solution {
    public int minPathSum(int[][] grid) {
        int er= grid.length;
        int ec=grid[0].length;
        int dp[][]= new int [er][ec];
        return minPathSumHelperDP(grid,0,0,er-1,ec-1,dp);
        
    }
        //using recursion
     public int minPathSumHelper(int [][] grid, int sr, int sc, int er, int ec)
    {
        if(sr==er && sc==ec)
        {
           return grid[sr][sc];
        }
        if(sr>er ||sc>ec)
        {
            return Integer.MAX_VALUE;
        }
        int f=minPathSumHelper(grid,sr+1,sc,er,ec);
        int s=minPathSumHelper(grid,sr,sc+1,er,ec);
        int ans=Math.min(f,s)+grid[sr][sc];
        return ans;
        
    }
    public int minPathSumHelperDP(int [][] grid, int sr, int sc, int er, int ec,int dp[][])
    {
        if(sr==er && sc==ec)
        {
           dp[sr][sc]=grid[sr][sc];
            return grid[sr][sc];
        }
        if(sr>er ||sc>ec)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        int f=minPathSumHelperDP(grid,sr+1,sc,er,ec,dp);
        int s=minPathSumHelperDP(grid,sr,sc+1,er,ec,dp);
        int ans=Math.min(f,s)+grid[sr][sc];
        dp[sr][sc]=ans;
        return dp[sr][sc];
        
    }
}