class Solution {
    int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean checkWord(char[][] board,String word,int idx,int i,int j){
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean res = false;

        res = res || checkWord(board,word,idx + 1,i + 1,j) || checkWord(board,word,idx + 1,i,j  + 1) || checkWord(board,word,idx + 1,i  - 1,j) || checkWord(board,word,idx + 1,i,j - 1);

        board[i][j] = temp;

        return res;




    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i < board.length; i++){
            for(int j = 0;j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && checkWord(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
}