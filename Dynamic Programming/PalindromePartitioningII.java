class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean isPalindrome[][] = new boolean[n][n];
        for(int gap = 0;gap < n; gap++){
            for(int i = 0,j = gap; j < n; i++,j++){
                if(gap == 0){
                    isPalindrome[i][j] = true;
                }
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    isPalindrome[i][j] =  true;
                }
                else{
                    if(isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp,-1);
        return minCut(s,0,n-1,dp,isPalindrome);

    }
    public int minCut(String s,int si,int ei,int dp[],boolean isPalindrome[][]){
        if(isPalindrome[si][s.length() - 1] || si == s.length()){
            return dp[si] = 0;
        }
        if(dp[si] != -1){
            return dp[si];
        }
        int minVal = (int)1e9;
        for(int cut = si; cut < s.length(); cut++){
            if(isPalindrome[si][cut]){
                int ans = minCut(s,cut+1,ei,dp,isPalindrome);
                minVal = Math.min(minVal,1 + ans);
            }
        }
        return dp[si] = minVal;
    }
}
