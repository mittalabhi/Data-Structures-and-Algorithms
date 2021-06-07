class Solution {
    int[] par;
    public int findPar(int u){
        if(par[u] == u) return u;
        return par[u] = findPar(par[u]);
    }
    public boolean isSimilar(String str1,String str2){
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        return count > 2 ? false : true;
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int count = n;
        par = new int[n];

        for(int i = 0;i < n; i++){
            par[i] = i;
        }

        for(int i = 0;i < n;i++){
            int par1 = findPar(i);
            for(int j = i + 1;j < n; j++){
               // int par2 = par[j];
                if(isSimilar(strs[i],strs[j])){
                    int par2 = findPar(j);
                    if(par1 != par2){
                      par[par2] = par1;
                      count--;
                    }
                }
            }
        }
        return count;
    }
}
