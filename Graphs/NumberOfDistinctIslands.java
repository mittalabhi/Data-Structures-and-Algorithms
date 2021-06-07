public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
        String shape = "";
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        char side[] = {'r','l','d','u'};
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        if(grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        
        HashSet<String> hm = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        //String shape = "";
        for(int i =0;i < n ;i++)
        {
            for(int j = 0; j < m;j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid,i,j);
                    System.out.print(shape);
                    hm.add(shape);
                    shape = "";
                }
            }
        }
        return hm.size();
    }
    public void dfs(int[][] grid,int i,int j)
    {
        grid[i][j] = 0;
        for(int d = 0; d < 4;d++)
        {
            int x = i + dir[d][0];
            int y = j + dir[d][1];

            if(x >= 0 && y >=0 && x < grid.length && y < grid[0].length && grid[x][y] == 1 )
            {
                shape += side[d];
                dfs(grid,x,y);
                shape += 'b';
            }
        }
    }
}
