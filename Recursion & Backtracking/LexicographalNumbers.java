class Solution {
    List<Integer> res = new ArrayList<>();
    public void lexOrder(int n,int i){
        if(i > n) return;
        if(i != 0) res.add(i);
        for(int j = 0;j <= 9; j++){
            if(i == 0 && j == 0) continue;
            if(i *10 + j > n) return;
            lexOrder(n,i * 10 + j);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        lexOrder(n,0);
        return res;
    }
}
