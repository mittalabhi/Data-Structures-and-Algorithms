class Solution {
     public List<List<String>> res = new ArrayList<>();

    public static boolean isSafe(Character[][] box,int r,int c){

      int[][] dirA = {{0,-1},{-1,0},{-1,-1},{-1,1}};
      for(int d = 0; d < dirA.length;d++){
        for(int rad = 1 ; rad<=box.length;rad++){
          int x = r + rad * dirA[d][0];
          int y = c + rad * dirA[d][1];

          if(x >= 0 && y >= 0 && x < box.length && y < box[0].length){
            if(box[x][y] == 'Q') return false;
          }else break;
        }
      }

      return true;
    }
    public void  makeAns(Character chess[][]){
        List<String> ans = new ArrayList<>();
        for(int i = 0;i < chess.length; i++){
            String str = "";
            for(int j = 0;j < chess[0].length; j++){
                str += chess[i][j];
            }
            ans.add(str);
        }
        res.add(ans);
    }
    public void Nqueen(Character chess[][],int idx,int count,int n){
        if(count == n){
            makeAns(chess);
            return;
        }

        for(int i =  idx;i < n * n; i++){
            int x = i / n;
            int y = i % n;

            if(isSafe(chess,x,y)){
                chess[x][y] = 'Q';
                Nqueen(chess,i + 1,count + 1,n);
                chess[x][y] = '.';
            }
        }
    }
    public int totalNQueens(int n) {
        Character chess[][] = new Character[n][n];
        for(Character[] cha : chess)Arrays.fill(cha,'.');
        Nqueen(chess,0,0,n);
        return res.size();
    }
}