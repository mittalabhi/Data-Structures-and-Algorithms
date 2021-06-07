public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
     public void bfs(int grid[][], int i, int j, int dis[][], int dir[][])
     {
         int n = grid.length;
         int m = grid[0].length;
         boolean visited[][] = new boolean[n][m];
         LinkedList<int []> que = new LinkedList<>();
         que.add(new int[]{i,j});
         visited[i][j] = true;
         int level = 0;
         while(que.size() != 0)
         {
             int size = que.size();
             while(size-- >0)
             {
                 int arr[] = que.removeFirst();
                 dis[arr[0]][arr[1]] += level;
                 for(int d = 0;d < 4;d++)
                 {
                     int x = arr[0] + dir[d][0];
                     int y = arr[1] + dir[d][1];
                     if(x>=0 && y>=0 && x < grid.length && y < grid[0].length && visited[x][y] == false)
                     {
                        visited[x][y] = true;
                        que.addLast(new int[]{x,y});
                     }

                 }
             }
             level++;
         }
     }
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        int dir[][] = {{0,-1},{-1,0},{0,1},{1,0}};
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                if(grid[i][j] == 1)
                {
                    bfs(grid,i,j,dis,dir);
                }
            }
        }
        int min = (int)1e9;
        for(int i =0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                System.out.print(dis[i][j]+ " ");
                min = Math.min(min,dis[i][j]);
            }
            System.out.println();
        }
        return min;
    }
}