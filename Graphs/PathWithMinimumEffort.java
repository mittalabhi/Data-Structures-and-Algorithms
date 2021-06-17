class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int efforts[][] = new int[m][n];
        for(int arr[] : efforts)Arrays.fill(arr,(int)1e9);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> { return a[2] - b[2]; });
        efforts[0][0] = 0;
        pq.add(new int[]{0,0,0});
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(pq.size() != 0){
            int size = pq.size();
            while(size --> 0){
                int arr[] = pq.poll();
                int x = arr[0];
                int y = arr[1];
                int maxEffort = arr[2];
                
                if(x == m-1 && y == n - 1){
                    return maxEffort;
                }
                for(int d = 0;d < dir.length;d++){
                    int X = x + dir[d][0];
                    int Y = y + dir[d][1];
                    
                    if(X < 0 || Y < 0 || X > m - 1 || Y > n - 1) continue;
                    
                    int newEffort = Math.max(maxEffort,Math.abs(heights[x][y] - heights[X][Y]));
                    if(newEffort < efforts[X][Y])
                    {
                        efforts[X][Y] = newEffort;
                        pq.add(new int[] {X,Y,newEffort});
                    }
                }
            }
        }
        return 0;
    }
}