class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1)
            return -1;
        
        LinkedList<int []> queue = new LinkedList<>();
        int level = 1;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        while(queue.size()!=0)
        {
            int size = queue.size();
            while(size-->0)
            {
                int arr[] = queue.removeFirst();
                if(arr[0] == n-1 && arr[1] == m-1)
                {
                    return level;
                }
                for(int d = 0; d < 8 ; d++)
                {
                    int x = arr[0] + dir[d][0];
                    int y = arr[1] + dir[d][1];
                    if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0)
                    {
                        grid[x][y] = 1;
                        queue.addLast(new int[]{x,y});
                    }
                }
                
            }
            level++;
        }
        return -1;
    }
}