public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        int n = rooms.length;
        int m = rooms[0].length;
        LinkedList<int []> queue = new LinkedList<>();
        int level=0;
        int dir[][] = { {0,-1},{0,1},{-1,0},{1,0}};
        boolean visited[][] = new boolean [n][m];
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                if(rooms[i][j] == 0)
                {
                    queue.addFirst(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        while(queue.size() != 0)
        {
            int size = queue.size();
            System.out.println(size);
            while(size -->0)
            {
                int arr[] = queue.removeFirst();
                rooms[arr[0]][arr[1]] = level;
                for(int d =0; d < 4; d++)
                {
                    int x = arr[0] + dir[d][0];
                    int y = arr[1] + dir[d][1];

                    if(x >= 0 && y >= 0 && x < n && y <m && rooms[x][y] != -1  && visited[x][y]==false)
                    {
                        visited[x][y] = true;
                        queue.addLast(new int[]{x,y});
                    }
                }
            }
            level++;
        }
    }
}
