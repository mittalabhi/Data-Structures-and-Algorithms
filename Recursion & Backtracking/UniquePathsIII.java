class Solution {
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public int findPaths(int [][]grid,int sr,int sc,int er,int ec,boolean visited[][],String psf,int zeroesCount)     {
        if(sr == er && sc == ec){
            System.out.println(psf+ "C" + zeroesCount + "END");

           if(zeroesCount == -1){
                return 1;
           }
           return 0;
        }
        int count = 0;
        //visited[sr][sc] = true;
        for(int  d = 0;d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if(x >= 0 && y >=0 && x < grid.length && y < grid[0].length && (grid[x][y] == 0 || grid[x][y] == 2)){
                zeroesCount--;
                if(grid[x][y] == 2) count += findPaths(grid,x,y,er,ec,visited,psf + x + " "+ y + ",",zeroesCount);
                else{
                    grid[x][y] = -1;
                    count += findPaths(grid,x,y,er,ec,visited,psf + x + " "+ y + ",",zeroesCount);
                    grid[x][y] = 0;
                }
                zeroesCount++;


            }
        }


        return count;

    }
    public int uniquePathsIII(int[][] grid) {
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 0;
        int zeroesCount = 0;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] == 2){
                    er = i;
                    ec = j;
                }
                if(grid[i][j] == 0){
                    zeroesCount++;
                }
            }
        }
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int ans = findPaths(grid,sr,sc,er,ec,visited,"",zeroesCount);
        return ans;

    }
}
