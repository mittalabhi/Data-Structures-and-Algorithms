public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
    //calculating row index
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    row.add(i);
                }
            }
        }
        //calculating col index
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j < n;j++){
                if(grid[j][i] == 1){
                    col.add(i);
                }
            }
        }
        //cal mid points
        int xcor = row.get(row.size() / 2);
        int ycor = col.get(col.size() / 2);
//calc distance
        int dis = 0;
        for(int ele : row){
            dis += Math.abs(xcor - ele);
        }
        for(int ele : col){
            dis += Math.abs(ycor - ele);
        }
        return dis;
    }
}