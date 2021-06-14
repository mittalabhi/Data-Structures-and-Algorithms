class Solution {
    boolean isClosed = true;
    public void dfs(int [][] grid,int sr,int sc){
        if(sr < 0 || sc < 0 || sr > grid.length - 1 || sc > grid[0].length - 1){
            isClosed = false;
            return;
        }
        if(grid[sr][sc] == 1 || grid[sr][sc] == 2){
            return;
        }
        grid[sr][sc] = 2;
        dfs(grid,sr + 1,sc);
        dfs(grid,sr,sc + 1);
        dfs(grid,sr - 1,sc);
        dfs(grid,sr,sc - 1);
    }
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j);
                    if(isClosed) count++;
                    else{
                        isClosed = true;
                    }
                }
            }
        }
        return count;
    }
}
