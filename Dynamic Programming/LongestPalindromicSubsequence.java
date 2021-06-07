class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        return longestPalindromeSubseqHelperDP(s,0,s.length() -1,dp);
    }
    public int longestPalindromeSubseqHelper(String s,int si,int ei){
        if(si == ei){
            return 1;
        }
        if(si > ei){
            return 0;
        }
        int ans1 = 0;
        if(s.charAt(si) == s.charAt(ei)){
            ans1 = 2 + longestPalindromeSubseqHelper(s,si+1,ei-1);
            return ans1;
        }
        ans1 = Math.max(longestPalindromeSubseqHelper(s,si+1,ei),longestPalindromeSubseqHelper(s,si,ei-1));
        return ans1;
    }
    public int longestPalindromeSubseqHelperDP(String s,int si,int ei,int dp[][]){

         if(si > ei){
             dp[si][ei] = 0;
            return 0;
        }
        if(si == ei){
            dp[si][ei] = 1;
            return 1;
        }

        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        int ans1 = 0;
        if(s.charAt(si) == s.charAt(ei)){
            dp[si][ei] = 2 + longestPalindromeSubseqHelperDP(s,si+1,ei-1,dp);
            //dp[si][ei] = ans1;
            //return ans1;
        }
        else
        {
            dp[si][ei] = Math.max(longestPalindromeSubseqHelperDP(s,si+1,ei,dp),longestPalindromeSubseqHelperDP(s,si,ei-1,dp));
            //dp[si][ei] = ans1;
        }

        return dp[si][ei];
    }
}