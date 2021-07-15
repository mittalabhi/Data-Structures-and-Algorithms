class Solution {
    int n;
     private int[] getPosition(int num)
    {
        int row = num / n + (num % n == 0 ? 0 : 1);
        int col = num % n == 0 ? n : num % n;
        return row % 2 == 0 ? new int[]{n - row, n - col} : new int[]{n - row, col - 1};
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        LinkedList<Integer> que = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        que.add(1);
        int level = 0;
        while(que.size() != 0)
        {
            int size = que.size();
            while(size --> 0)
            {
                int idx = que.removeFirst();
                if(hs.contains(idx)) continue;
                hs.add(idx);
                if(idx == n*n)
                    return level;
                
                for(int i = 1; i <= 6;i++)
                {
                    int p[] = getPosition(idx+i);
                    int a = p[0];
                    int b =p[1];
                    if(a < 0 || b < 0 || a > n-1 || b >n-1) continue;
                    if(board[a][b] == -1)
                        que.add(idx + i);
                    else
                        que.add(board[a][b]);
                }
            }
            level++;
        }
        return -1;
    }
}