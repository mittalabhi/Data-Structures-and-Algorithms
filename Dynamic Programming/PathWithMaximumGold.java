class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] != 0)
                    ans = Math.max(getMaximumGoldHelper(grid,i,j,visited),ans);
            }
        }
        return ans;

    }
    public int getMaximumGoldHelper(int [][]grid,int i,int j,boolean visited[][]){
        if(i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0 || visited[i][j] == true){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        visited[i][j] = true;
        int l = getMaximumGoldHelper(grid,i,j+1,visited);
        int r = getMaximumGoldHelper(grid,i+1,j,visited);
        int b = getMaximumGoldHelper(grid,i-1,j,visited);
        int u = getMaximumGoldHelper(grid,i,j-1,visited);
        int ans = Math.max(Math.max(l,r),Math.max(b,u));
        ans =  ans + grid[i][j];
        visited[i][j] = false;
        return ans;

    }
}