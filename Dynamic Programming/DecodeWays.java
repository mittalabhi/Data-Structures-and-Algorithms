class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return numDecodingsHelperDP(s,0,dp);
    }
    public int numDecodingsHelperDP(String s,int idx,int []dp){
        if(idx == s.length()){
            return 1;
        }
        char ch = s.charAt(idx);
        if(ch == '0'){
            dp[idx] = 0;
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int ans1 = numDecodingsHelperDP(s,idx+1,dp);
        int ans2 = 0;
        if(idx < s.length() - 1){
            char ch1 = s.charAt(idx);
            char ch2 = s.charAt(idx+1);
            int num = (ch1 - '0')*10 + (ch2 - '0');
            if(num <= 26){
                ans2 = numDecodingsHelperDP(s,idx+2,dp);
            }
        }
        return dp[idx] = ans1 + ans2;
    }
}
