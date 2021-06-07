class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int indegree[][] = new int[n][m];
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                for(int d = 0;d < 4; d++){
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];

                    if(x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]){
                        indegree[x][y]++;
                    }
                }
            }
        }
        LinkedList<int[]> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                if(indegree[i][j] == 0){
                    que.add(new int[]{i,j});
                    ans.add(matrix[i][j]);
                }
            }
        }
        int level = 0;
        System.out.print(que.size());
        while(que.size() != 0){
            int size = que.size();
            while(size -- > 0){
                int arr[] = que.removeFirst();
                int idx1 = arr[0];
                int idx2 = arr[1];

                for(int d = 0;d < 4; d++){
                    int x = idx1 + dir[d][0];
                    int y = idx2 + dir[d][1];

                    if(x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[idx1][idx2] && --indegree[x][y] == 0){
                        que.addLast(new int[]{x,y});
                        ans.add(matrix[x][y]);
                    }

                }
            }
            level++;
        }
        System.out.print(ans);
        return level;
    }
}