class Solution {
    int n;
    int m;
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int color = 2;
        for(int i =0;i < n;i++)
        {
            for(int j =0;j < m;j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid,i,j,color);
                     color++;
                }
               
            }
        }
        LinkedList<int []> que = new LinkedList<>();
        for(int i =0;i < n;i++)
        {
            for(int j =0;j < m;j++)
            {
                if(grid[i][j] == 3){
                    que.addLast( new int[]{i,j});
                }
            }
        }
        for(int i = 0;i < n ; i++){
            for(int j = 0;j < m; j++){
                System.out.print(grid[i][j] + " ");
            }
             System.out.println();
        }
       boolean visited[][] = new boolean [n][m];
        int level = 0;
        while(que.size() != 0){
            int size = que.size();
            while(size --> 0)
            {
                int ar[] = que.removeFirst();
                int a = ar[0];
                int b = ar[1];
               if(visited[a][b]) continue;
               visited[a][b] = true;
                if(grid[a][b] == 2)
                {
                    return level - 1;
                }
                for(int d = 0;d < 4; d++)
                {
                    int x = a + dir[d][0];
                    int y = b + dir[d][1];
                    if(x < 0 || y < 0 || x > n-1 || y > m-1 || grid[x][y] == 3)
                        continue;
                    que.addLast(new int[]{x,y});
                }
            }
            level++;
        }
        //level = level - 1;
        //System.out.print(level);
        return 0;
                           
                           
    }
    public void dfs(int [][]grid,int i,int j,int color)
    {
        if(i < 0 || j < 0 || i > n-1 || j > m-1 || grid[i][j] == 0 || grid[i][j] == color)
            return;
        grid[i][j] = color;
        for(int d = 0;d < 4;d++)
        {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            dfs(grid,x,y,color);
            
        }
    }
}