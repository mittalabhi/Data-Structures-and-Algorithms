class Solution {
    public int countSubstrings(String s) {

        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;
        for(int gap = 0;gap < s.length();gap++){
            for(int i = 0,j = gap;j < s.length(); i++,j++){
                if(gap == 0)dp[i][j] = true;
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }
                }
            }
        }
        for(int i = 0; i < s.length();i++){
            for(int j = 0;j < s.length(); j++){
                if(dp[i][j] == true){
                    count++;
                }
            }
             //System.out.println();
        }

    return count;
    }
}