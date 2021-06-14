class Solution {
    public boolean isValid(char[][] board, int x,int y)
    {
        char ch = board[x][y];
        for(int i = 0; i < board.length;i++)
        {
            if(board[i][y] == ch && x != i) return false;
        }
        for(int i = 0;i < board[0].length;i++)
        {
            if(board[x][i] == ch && y != i) return false;
        }
        int a = 3 * (x/3);
        int b = 3 * (y/3);
        for(int i = 0; i < 3;i++)
        {
            for(int j = 0; j < 3;j++)
            {
                if(board[a + i][b + j]== ch && a + i != x && b + j != y) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0;i < board.length;i++)
        {
            for(int j = 0;j < board[0].length;j++)
            {
                if(board[i][j] != '.')
                {
                    boolean ans = isValid(board,i,j);
                    if(ans == false) return false;
                }
            }
        }
        return true;
    }
}