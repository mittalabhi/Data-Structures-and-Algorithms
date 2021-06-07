class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int d[] : dp)Arrays.fill(d,-1);
        return minDistanceHelper(word1,word2,word1.length()-1,word2.length()-1,dp);
    
    }
    public int minDistanceHelper(String word1,String word2,int m,int n,int dp[][]){
        if(m==-1 ||n==-1)
        {
        if(m==-1)
            {
                //dp[m][n]=n;
                return n+1;
            }
            else if(n==-1)
                return m+1 ;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(word1.charAt(m) == word2.charAt(n)){
            dp[m][n] = minDistanceHelper(word1,word2,m-1,n-1,dp);
        }

        else{
            dp[m][n] = 1 + Math.min(Math.min(minDistanceHelper(word1,word2,m-1,n,dp),minDistanceHelper(word1,word2,m,n-1,dp)),minDistanceHelper(word1,word2,m-1,n-1,dp));
        }
        return dp[m][n];
    }
}