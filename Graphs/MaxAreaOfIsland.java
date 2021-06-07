class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0;i < grid.length;i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                int ans = 0;
                if(grid[i][j] == 1)
                {
                     ans = dfs(i,j,grid);
                }
                 max = Math.max(max,ans);
            }
         }
        return max;
    }

    public int dfs(int i,int j,int[][] grid)
    {
        if(!(i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[0].length - 1 && grid[i][j] == 1))         {
            return 0;
        }
        int count = 0;
        grid[i][j] = 0;

        count += dfs(i,j+1,grid);
        count += dfs(i,j-1,grid);
        count += dfs(i-1,j,grid);
        count += dfs(i+1,j,grid);
        return count + 1;

    }


}