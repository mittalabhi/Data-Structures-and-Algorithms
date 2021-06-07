class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int er=obstacleGrid.length;
        int ec= obstacleGrid[0].length;
        int dp[][]= new int[er][ec];
       return uniquePathsWithObstaclesHelperDP(obstacleGrid,0,0,er-1,ec-1,dp);
    }
        
    //using recursion
    public int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int sr, int sc, int er , int ec)
    {
        if(sr==er && sc==ec && obstacleGrid[sr][sc]!=1){
        
            return 1;
        }
        if(sr>er || sc>ec ||obstacleGrid[sr][sc]==1 )
            return 0;        
        int f=uniquePathsWithObstaclesHelper(obstacleGrid,sr+1,sc,er,ec);
        int s=uniquePathsWithObstaclesHelper(obstacleGrid,sr,sc+1,er,ec);
        int ans=f+s;
        return ans;
    }
     public int uniquePathsWithObstaclesHelperDP(int[][] obstacleGrid, int sr, int sc, int er , int ec , int dp[][])
    {
        if(sr==er && sc==ec && obstacleGrid[sr][sc]!=1){
            dp[sr][sc]=1;
            return 1;
        }
        if(sr>er || sc>ec ||obstacleGrid[sr][sc]==1 )
            return 0;   
         if(dp[sr][sc]!=0)
         {
             return dp[sr][sc];
         }
        int f=uniquePathsWithObstaclesHelperDP(obstacleGrid,sr+1,sc,er,ec,dp);
        int s=uniquePathsWithObstaclesHelperDP(obstacleGrid,sr,sc+1,er,ec,dp);
        int ans=f+s;
         dp[sr][sc]=ans;
        return dp[sr][sc];
    }
}